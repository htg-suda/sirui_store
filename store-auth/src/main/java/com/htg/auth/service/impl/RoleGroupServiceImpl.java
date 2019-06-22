package com.htg.auth.service.impl;

import com.htg.common.entity.auth.RoleGroup;
import com.htg.auth.mapper.RoleGroupMapper;
import com.htg.auth.service.IRoleGroupService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限组表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-10
 */
@Service
public class RoleGroupServiceImpl extends ServiceImpl<RoleGroupMapper, RoleGroup> implements IRoleGroupService {

}
