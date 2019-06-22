package com.htg.auth.service.impl;

import com.htg.common.entity.auth.GroupPermissionMapping;
import com.htg.auth.mapper.GroupPermissionMappingMapper;
import com.htg.auth.service.IGroupPermissionMappingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-10
 */
@Service
public class GroupPermissionMappingServiceImpl extends ServiceImpl<GroupPermissionMappingMapper, GroupPermissionMapping> implements IGroupPermissionMappingService {

    @Override
    public List<GroupPermissionMapping> selectByGroupIdList(List<Integer> groupIdList) {

       return baseMapper.selectByGroupId(groupIdList);
    }
}
