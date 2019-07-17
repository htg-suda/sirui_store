package com.htg.user.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.dto.custom.ModifyCusServiceDto;
import com.htg.common.entity.custom.CustomServiceInfo;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.vo.user.admin.CustomServiceUserInfoVo;

/**
 * <p>
 * 客服信息表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-06-25
 */
public interface ICustomServiceInfoService extends IService<CustomServiceInfo> {

    CommonResult<RespId> addCustomServiceInfo(CustomServiceInfo customServiceInfo);


    CommonResult<CustomServiceInfo> getCustomServiceInfo(Integer userId);

    CommonResult<RespPage<CustomServiceUserInfoVo>> searchCustomSerivce(Page<CustomServiceUserInfoVo> page, String tel, String serviceName);

    CommonResult<CustomServiceUserInfoVo> getCustomServiceInfoById(Integer id);

    CommonResult modifyCustomService(ModifyCusServiceDto modifyCusServiceDto);

}
