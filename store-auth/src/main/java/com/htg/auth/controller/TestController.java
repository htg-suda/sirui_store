package com.htg.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class TestController {
    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id) {
        return "Product id is " + id;
    }

}
