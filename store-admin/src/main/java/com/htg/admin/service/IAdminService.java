package com.htg.admin.service;

import com.htg.common.entity.Admin;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-06-09
 */
public interface IAdminService extends IService<Admin> {

    Admin selectByName(String name);
}
