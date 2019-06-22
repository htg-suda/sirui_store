package com.htg.user.mapper;

import com.htg.common.bo.user.SrUserBO;
import com.htg.common.entity.user.SrUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-06-13
 */
public interface SrUserMapper extends BaseMapper<SrUser> {

    SrUserBO selectByUserName(String username);

    SrUserBO selectByTel(String tel);

    SrUserBO selectByEmail(String email);
}
