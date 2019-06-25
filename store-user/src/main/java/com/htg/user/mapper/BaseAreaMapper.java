package com.htg.user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.htg.common.entity.area.BaseArea;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-06-25
 */
public interface BaseAreaMapper extends BaseMapper<BaseArea> {

    List<BaseArea> selectByParentId(Integer parentId);

    BaseArea selectByCodeId(Integer codeId);
}
