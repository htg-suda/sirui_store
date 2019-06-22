package com.htg.user.service.impl;

import com.htg.common.bo.user.SrUserBO;
import com.htg.common.constant.CodeConst;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.dto.seller.user.SrUserDto;
import com.htg.common.entity.user.SrUser;
import com.htg.common.entity.user.UserRoleGroup;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.user.constant.UserConst;
import com.htg.user.mapper.SrUserMapper;
import com.htg.user.service.ISrUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.user.service.IUserRoleGroupService;
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
@Service
public class SrUserServiceImpl extends ServiceImpl<SrUserMapper, SrUser> implements ISrUserService {
    @Autowired
    private IUserRoleGroupService iUserRoleGroupService;
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
                username = "BD_" + RandomStringUtils.randomAlphabetic(6);
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

        /* 对用户密码进行 加密 */
        String password = srUser.getPassword();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String ePass = encoder.encode(password);
        srUser.setPassword(ePass);

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


