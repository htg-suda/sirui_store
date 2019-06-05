package com.htg.good.mapper;

import com.htg.common.entity.GoodCategory;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 商品分类表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface GoodCategoryMapper extends BaseMapper<GoodCategory> {
    List<GoodCategory> selectByParentId(Integer parentId);

    Integer selectCountParentIdAnName(Integer parentId,String name);
}
