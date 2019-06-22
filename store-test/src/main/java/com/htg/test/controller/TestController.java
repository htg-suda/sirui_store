package com.htg.test.controller;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
@Api(value = "TestController", tags = "测试服务")
public class TestController {
    @GetMapping("/{value}")
    @PreAuthorize("hasAnyAuthority('sys:category:list_child_category')")
    public String test(@PathVariable String value) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("==========> {}", authentication);
        log.info("==========> {}", authentication.getName());
        log.info("==========> {}", authentication.getAuthorities());
        log.info("==========> {}", authentication.getDetails());
        log.info("==========> {}", authentication.getPrincipal());

        return "test success is " + value;
    }
}
