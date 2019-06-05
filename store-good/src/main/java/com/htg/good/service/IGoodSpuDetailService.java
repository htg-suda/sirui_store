package com.htg.good.service;

import com.htg.common.entity.GoodSpuDetail;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品spu详情表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface IGoodSpuDetailService extends IService<GoodSpuDetail> {

    GoodSpuDetail selectBySpuId(Integer spuId);
}
