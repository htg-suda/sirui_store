package com.htg.user.controller.user;

import com.htg.common.dto.seller.user.SrUserDto;
import com.htg.common.entity.custom.CustomServiceInfo;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.utils.AuthUtil;
import com.htg.common.vo.user.user.UserInfo;
import com.htg.user.service.ICustomServiceInfoService;
import com.htg.user.service.ISrUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-06-13
 */

@Slf4j
@Api(value = "SrUserController", tags = "001-用户-用户行为")
@Validated
@RestController
@RequestMapping("/user")
public class SrUserController {
    @Autowired
    private ISrUserService srUserService;

    @Autowired
    private ICustomServiceInfoService customServiceInfoService;
 /*   @ApiOperation(value = "注册用户")
    @ResponseBody
    @PostMapping("/register")
    public CommonResult<RespId> addUser(@Valid @RequestBody SrUser srUser) throws GlobalException {
        return srUserService.addUser(srUser);
    }*/


    /* 获取用户信息*/
    @ApiOperation(value = "用户手机号码 + 验证码 注册")
    @ResponseBody
    @PostMapping("/register_by_tel")
    public CommonResult<RespId> addUser(@Valid @RequestBody SrUserDto srUserDto) throws GlobalException {
        return srUserService.addUser(srUserDto);
    }


    @ApiOperation(value = "获取用户基本信息服务")
    @ResponseBody
    @PostMapping("/get_user_info")
    public CommonResult<UserInfo> getUserInfo() throws GlobalException {
        Integer userId = AuthUtil.getLoginUserId();
        return srUserService.getUserInfo(userId);
    }

    @ApiOperation(value = "获取用户基本信息服务")
    @ResponseBody
    @GetMapping("/custom_service_info")
    public CommonResult<CustomServiceInfo> getCustomServiceInfo() throws GlobalException {
        Integer userId = AuthUtil.getLoginUserId();
        return customServiceInfoService.getCustomServiceInfo(userId);
    }
}

