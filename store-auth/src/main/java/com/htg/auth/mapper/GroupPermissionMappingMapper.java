package com.htg.auth.mapper;

import com.htg.common.entity.auth.GroupPermissionMapping;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-06-10
 */
public interface GroupPermissionMappingMapper extends BaseMapper<GroupPermissionMapping> {

    List<GroupPermissionMapping> selectByGroupId(List<Integer> groupIdList);

}
