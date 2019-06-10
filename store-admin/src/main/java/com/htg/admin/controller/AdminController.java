package com.htg.admin.controller;


import com.htg.admin.service.IAdminService;
import com.htg.common.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-06-09
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("/{name}")
    public Admin getUserByName(@PathVariable String name) {
        return adminService.selectByName(name);
    }


}

