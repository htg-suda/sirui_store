package com.htg.user.controller.inner;


import com.htg.common.bo.user.SrUserBO;
import com.htg.user.service.ISrUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "InnerController", tags = "999-内部用户接口")
@Validated
@RestController
@RequestMapping("/user")
public class UserInnerController {
    @Autowired
    private ISrUserService srUserService;
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
