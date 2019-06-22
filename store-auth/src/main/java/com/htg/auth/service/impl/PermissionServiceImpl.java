package com.htg.auth.service.impl;

import com.htg.common.entity.auth.Permission;
import com.htg.auth.mapper.PermissionMapper;
import com.htg.auth.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-10
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
