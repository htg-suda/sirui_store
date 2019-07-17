package com.htg.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.bo.user.SrUserBO;
import com.htg.common.constant.*;
import com.htg.common.dto.seller.user.ResetPasswordDto;
import com.htg.common.dto.seller.user.SrUserDto;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.entity.user.SrUser;
import com.htg.common.entity.user.UserRoleGroup;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.vo.seller.user.SellerStatusInfo;
import com.htg.common.vo.user.user.UserInfo;

import com.htg.user.constant.UserConst;
import com.htg.user.mapper.SrUserMapper;
import com.htg.user.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-13
 */
@Slf4j
@Service
public class SrUserServiceImpl extends ServiceImpl<SrUserMapper, SrUser> implements ISrUserService {
    @Autowired
    private IUserRoleGroupService iUserRoleGroupService;

    @Autowired
    private ISellerInfoService iSellerInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    @Transactional
    public CommonResult<RespId> addUser(SrUserDto srUserDto) throws GlobalException {
        SrUser srUser = new SrUser();
        BeanUtils.copyProperties(srUserDto, srUser);
        String username = srUser.getUsername();
        if (StringUtils.isBlank(username)) {
            do {    // 用户名为空的时候 就循环生成用户名
                username = "BD_" + RandomStringUtils.randomAlphabetic(8);
            } while (getUserByName(username) != null);
        } else if (getUserByName(username) != null) {
            throw new GlobalException(CodeEnum.USERNAME_HAS_EXIST);
        }
        srUser.setUsername(username);
        String tel = srUser.getTel();

        /* 校验验证码 */
        if (!checkMsgCode(tel, srUserDto.getCode())) throw new GlobalException(CodeEnum.MSG_CODE_VALID_FAILED);

        String email = srUser.getEmail();

        if (tel != null && getUserByTel(tel) != null) throw new GlobalException(CodeEnum.TEL_HAS_EXIST);
        if (email != null && getUserByEmail(email) != null) throw new GlobalException(CodeEnum.EMAIL_HAS_EXIST);
        /* 设置 用户信息 */
        srUser.setId(null);
        srUser.setDelFlag(Del_FLAG.EXISTED);
        srUser.setStatus(UserConst.STATUS_ACTIVE);
        /* 注册时将商户 id 设置为空 */
        srUser.setSellerId(null);
        /* 对用户密码进行 加密 */

        String password = srUser.getPassword();
        if(!StringUtils.isBlank(password)){
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String ePass = encoder.encode(password);
            srUser.setPassword(ePass);
        }
        /* 存入数据库 */
        if (!insert(srUser)) throw new GlobalException(CodeEnum.REGISTER_USER_ERROR);

        Integer userId = srUser.getId();
        /* 注册成功后,将用户添加到默认的用户组  */
        UserRoleGroup userRoleGroup = new UserRoleGroup();
        userRoleGroup.setId(null);
        userRoleGroup.setUserId(userId);
        userRoleGroup.setRoleGroupId(UserConst.ROLE_GROUP_USER_ID);
        if (!iUserRoleGroupService.insert(userRoleGroup)) throw new GlobalException(CodeEnum.REGISTER_USER_ERROR);

        return CommonResult.success(new RespId(srUser.getId()));
        /*todo  注册成功 应该不止这些数据的调用 ,还有用户组信息 ,权限 ,用户其他详情数据  */
    }

    /* 获取商户状态 */
    @Override
    public CommonResult<SellerStatusInfo> getSellerStatusInfo(Integer userId) {
        SrUser srUser = selectById(userId);
        Integer sellerId = srUser.getSellerId();
        SellerStatusInfo sellerStatusInfo = new SellerStatusInfo();
        if (sellerId == null) {
            sellerStatusInfo.setShopStatus(ShopConst.STATE_HAS_NO_SELLER_INFO);
            return CommonResult.success(sellerStatusInfo);
        }
        SellerInfo sellerInfo = iSellerInfoService.selectById(sellerId);


        SellerStore store = null;
        try {
            store = iSellerInfoService.getStoreByUserId(userId);
        } catch (GlobalException e) {
            // e.printStackTrace();
            log.info("user has no store");
        }
        Integer state = sellerInfo.getState();

        switch (state) {
            case SellerConst.STATE_WAIT_FOR_VERIFY:  //待审核
                sellerStatusInfo.setShopStatus(ShopConst.STATE_WAIT_VERIFY);
                break;
            case SellerConst.STATE_VERIFY_PASS:     // 审核通过的话就去查看店铺的状态
                if (store == null) {                // 店铺存在
                    sellerStatusInfo.setShopStatus(ShopConst.STATE_VERIFY_PASS_NO_STORE);
                } else if (store.getStatus() == StoreConst.STATUS_ACTIVE) {  // 店铺处在激活状态
                    sellerStatusInfo.setShopStatus(ShopConst.STATE_VERIFY_PASS_HAS_STOER_ACTIVE);
                } else {                                                 // 店铺存在,但是未激活
                    sellerStatusInfo.setShopStatus(ShopConst.STATE_VERIFY_PASS_HAS_STOER_FROZEN);
                }
                break;
            case SellerConst.STATE_VERIFY_UNPASS:   // 审核未通过
                sellerStatusInfo.setShopStatus(ShopConst.STATE_VERIFY_UNPASS);
                break;
            case SellerConst.STATE_FROZEN:          // 商户已经冻结
                sellerStatusInfo.setShopStatus(ShopConst.STATE_SELLER_FROZEN);
                break;
        }
        return CommonResult.success(sellerStatusInfo);
    }


    @Override
    public CommonResult<UserInfo> getUserInfo(Integer userId) {
        UserInfo userInfo = new UserInfo();
        SrUser srUser = baseMapper.selectById(userId);
        BeanUtils.copyProperties(srUser, userInfo);
        return CommonResult.success(userInfo);
    }

    @Override
    public CommonResult resetPasswordByTel(ResetPasswordDto resetPasswordDto) {
        String smsCode = resetPasswordDto.getSmsCode();
        String tel = resetPasswordDto.getTel();
        String newPass = resetPasswordDto.getNewPass();
        if (!checkMsgCode(tel, smsCode)) throw new GlobalException(CodeEnum.MSG_CODE_VALID_FAILED);

        SrUserBO userBO = getUserByTel(tel);
        if (userBO == null) throw new GlobalException(CodeEnum.USER_NOT_EXIST);

        Integer id = userBO.getId();
        SrUser srUser=new SrUser();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String ePass = encoder.encode(newPass);
        srUser.setId(id);
        srUser.setPassword(ePass);
       if(updateById(srUser)){
           return CommonResult.success("修改成功");
       }else {
           return CommonResult.success("修改失败");
       }
    }


    @Override
    public SrUserBO getUserByName(String username) {
        return baseMapper.selectByUserName(username);
    }

    @Override
    public SrUserBO getUserByTel(String tel) {
        return baseMapper.selectByTel(tel);
    }

    @Override
    public SrUserBO getUserByEmail(String email) {
        return baseMapper.selectByEmail(email);
    }


    public boolean checkMsgCode(String tel, String msgCode) {
        String key = CodeConst.CODE_PREFIX + tel;
        Long remainTime = redisTemplate.getExpire(key);
        /* 验证码过期后 取值为 -2 */
        if (remainTime > 0) {
            String storeCode = redisTemplate.opsForValue().get(key);
            if (StringUtils.equals(msgCode, storeCode)) {   // redis 中的 code 和 传来的 验证码相同
                redisTemplate.delete(key);                          // 一旦验证成功就删除掉缓存中的验证码
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}


