package com.htg.good.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.entity.GoodSpu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品spu表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface GoodSpuMapper extends BaseMapper<GoodSpu> {
    List<GoodSpu> selectByPage(Page<GoodSpu> page, @Param("name") String name, @Param("storeId") Integer storeId, @Param("categoryId") Integer categoryId, @Param("brandId") Integer brandId);
}
