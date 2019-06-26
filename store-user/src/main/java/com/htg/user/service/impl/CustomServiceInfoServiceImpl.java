package com.htg.user.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.entity.custom.CustomServiceInfo;
import com.htg.common.entity.user.SrUser;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.vo.user.admin.CustomServiceUserInfoVo;
import com.htg.user.mapper.CustomServiceInfoMapper;
import com.htg.user.service.ICustomServiceInfoService;
import com.htg.user.service.ISrUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 客服信息表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-25
 */
@Service
public class CustomServiceInfoServiceImpl extends ServiceImpl<CustomServiceInfoMapper, CustomServiceInfo> implements ICustomServiceInfoService {
    @Autowired
    private ISrUserService userService;

    @Override
    public CommonResult<RespId> addCustomServiceInfo(CustomServiceInfo customServiceInfo) {
        Integer userId = customServiceInfo.getUserId();
        SrUser srUser = userService.selectById(userId);
        if (srUser == null) throw new GlobalException(CodeEnum.USER_NOT_EXIST);

        /*检测用户是否已经是 客服*/
        CustomServiceInfo serviceInfoExt = baseMapper.selectByUserId(userId);
        if (serviceInfoExt != null) throw new GlobalException(CodeEnum.CUSTOM_SERVICE_HAS_EXIST);

        customServiceInfo.setDelFlag(Del_FLAG.EXISTED);
        customServiceInfo.setId(null);
        if (insert(customServiceInfo)) {
            return CommonResult.success(new RespId(customServiceInfo.getId()));
        } else {
            return CommonResult.error("添加失败");
        }
    }

    @Override
    public CommonResult<CustomServiceInfo> getCustomServiceInfo(Integer userId) {
        CustomServiceInfo serviceInfoExt = baseMapper.selectByUserId(userId);
        if (serviceInfoExt == null) throw new GlobalException(CodeEnum.YOU_ARE_NOT_CUSTOM_SERVICE);
        return CommonResult.success(serviceInfoExt);
    }

    @Override
    public CommonResult<RespPage<CustomServiceUserInfoVo>> searchCustomSerivce(Page<CustomServiceUserInfoVo> page, String tel, String serviceName) {
        List<CustomServiceUserInfoVo> userInfoVos = baseMapper.selectCustomUserInfo(page, tel, serviceName);
        return CommonResult.success(new RespPage<>(userInfoVos, page.getPages()));
    }

    @Override
    public CommonResult<CustomServiceUserInfoVo> getCustomServiceInfoById(Integer id) {
        CustomServiceUserInfoVo customServiceUserInfoVo = baseMapper.selectCustomUserInfoById(id);
        if (customServiceUserInfoVo == null) throw new GlobalException(CodeEnum.CUSTOM_SERVICE_NOT_EXIST);
        return CommonResult.success(customServiceUserInfoVo);
    }
}
