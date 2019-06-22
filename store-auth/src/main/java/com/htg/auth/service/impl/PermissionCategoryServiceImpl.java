package com.htg.auth.service.impl;

import com.htg.common.entity.auth.PermissionCategory;
import com.htg.auth.mapper.PermissionCategoryMapper;
import com.htg.auth.service.IPermissionCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限分类表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-10
 */
@Service
public class PermissionCategoryServiceImpl extends ServiceImpl<PermissionCategoryMapper, PermissionCategory> implements IPermissionCategoryService {

}
