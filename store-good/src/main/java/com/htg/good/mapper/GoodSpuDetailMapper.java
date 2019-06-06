package com.htg.good.mapper;

import com.htg.common.entity.good.GoodSpuDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 商品spu详情表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface GoodSpuDetailMapper extends BaseMapper<GoodSpuDetail> {

    GoodSpuDetail selectBySpuId(Integer spuId);
}
