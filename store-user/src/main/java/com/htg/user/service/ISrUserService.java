package com.htg.user.service;

import com.htg.common.bo.user.SrUserBO;
import com.htg.common.dto.seller.user.SrUserDto;
import com.htg.common.entity.user.SrUser;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.vo.seller.user.SellerStatusInfo;
import com.htg.common.vo.user.user.UserInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-06-13
 */
public interface ISrUserService extends IService<SrUser> {

    CommonResult<RespId> addUser(SrUserDto srUserDto) throws GlobalException;

    SrUserBO getUserByName(String username);

    SrUserBO getUserByTel(String tel);

    SrUserBO getUserByEmail(String email);

    /* 获取商户状态 */
    CommonResult<SellerStatusInfo> getSellerStatusInfo(Integer userId);

    CommonResult<UserInfo> getUserInfo(Integer userId) throws GlobalException;
}
