package com.htg.feign.client;

import com.htg.common.bo.user.SrUserBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "store-user",path = "/user")
public interface UserClient {
    @GetMapping("/name/{name}")
    SrUserBO getUserByName(@PathVariable("name") String name);


    @GetMapping("/tel/{tel}")
    SrUserBO getUserByTel(@PathVariable("tel") String tel);


    @GetMapping("/email/{email}")
    SrUserBO getUserByEmail(@PathVariable("email") String email);
}
