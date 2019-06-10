package com.htg.good.mapper;

import com.htg.common.entity.good.GoodSku;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品的sku 表,具体到某一款商品 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface GoodSkuMapper extends BaseMapper<GoodSku> {

    List<GoodSku> selectBySpuId(Integer spuId);
}
