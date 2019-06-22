package com.htg.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product")
public class TestController {
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('sys:spec_group:list')")
    public String getProduct(@PathVariable String id) {
        log.info("id is {}", id);
        return "Product id is " + id;
    }

}
