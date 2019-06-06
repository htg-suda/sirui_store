package com.htg.good.mapper;

import com.htg.common.entity.good.GoodSpecGroup;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 规格组表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface GoodSpecGroupMapper extends BaseMapper<GoodSpecGroup> {
    List<GoodSpecGroup> selectSpecGroupByCategoryId(@Param("categoryId") Integer categoryId);

    Integer selectCountByCategoryIdAndName(Integer categoryId, String name);
}
