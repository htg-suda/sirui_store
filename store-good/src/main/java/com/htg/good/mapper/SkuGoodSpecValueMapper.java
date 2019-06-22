package com.htg.good.mapper;

import com.htg.common.entity.good.SkuGoodSpecValue;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品sku规格值表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
public interface SkuGoodSpecValueMapper extends BaseMapper<SkuGoodSpecValue> {

    List<SkuGoodSpecValue> selectBySkuId(Integer skuId);
}
