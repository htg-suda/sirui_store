package com.htg.auth.service;

import com.htg.common.entity.auth.GroupPermissionMapping;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author htg
 * @since 2019-06-10
 */
public interface IGroupPermissionMappingService extends IService<GroupPermissionMapping> {

    List<GroupPermissionMapping> selectByGroupIdList(List<Integer> groupIdList);
}
