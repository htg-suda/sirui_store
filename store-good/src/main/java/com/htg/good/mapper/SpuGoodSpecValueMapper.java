package com.htg.good.mapper;

import com.htg.common.entity.good.SpuGoodSpecValue;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品spu规格值表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
public interface SpuGoodSpecValueMapper extends BaseMapper<SpuGoodSpecValue> {

    List<SpuGoodSpecValue> selectBySpuId(Integer spuId);
}
