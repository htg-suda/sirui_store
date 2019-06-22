package com.htg.auth.controller;

import com.htg.common.result.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AdminController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @ApiOperation(value = "用户登录", notes = "根据用户名/手机号 密码登录")
    @ResponseBody
    @PostMapping("/admin/login")
    public CommonResult login(String username, String password) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(auth);

        /* 登录成功后 */
        if (authenticate != null && authenticate.isAuthenticated()) {
            /* 向当前线程写入 认证后的对象 */
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            return CommonResult.success("login success");
        }
        return CommonResult.error("login failed");
    }

}
