package com.htg.admin.mapper;

import com.htg.common.entity.admin.Admin;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-06-09
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Admin selectByName(String name);

}
