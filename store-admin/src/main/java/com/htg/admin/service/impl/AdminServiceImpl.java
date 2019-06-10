package com.htg.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.admin.mapper.AdminMapper;
import com.htg.admin.service.IAdminService;
import com.htg.common.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-09
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public Admin selectByName(String name) {
        return baseMapper.selectByName(name);
    }
}
