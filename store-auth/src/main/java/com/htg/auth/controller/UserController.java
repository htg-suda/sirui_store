package com.htg.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/me")
    public Authentication principal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("user is {}", authentication.getName());
        return authentication;
    }

}
