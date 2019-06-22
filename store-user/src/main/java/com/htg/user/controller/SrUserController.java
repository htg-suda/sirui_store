package com.htg.user.controller;

import com.htg.common.bo.user.SrUserBO;
import com.htg.common.dto.seller.user.SrUserDto;
import com.htg.common.entity.user.SrUser;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.user.service.ISrUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
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
@Api(value = "SrUserController", tags = "用户-用户行为")
@Validated
@RestController
@RequestMapping("/user")
public class SrUserController {
    @Autowired
    private ISrUserService srUserService;

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


    /*登录授权 */
    @GetMapping("/name/{name}")
    public SrUserBO getUserByName(@PathVariable("name") String name) {
        return srUserService.getUserByName(name);
    }


    @GetMapping("/tel/{tel}")
    public SrUserBO getUserByTel(@PathVariable("tel") String tel) {
        return srUserService.getUserByTel(tel);
    }


    @GetMapping("/email/{email}")
    public SrUserBO getUserByEmail(@PathVariable("email") String email) {
        return srUserService.getUserByEmail(email);
    }
}

