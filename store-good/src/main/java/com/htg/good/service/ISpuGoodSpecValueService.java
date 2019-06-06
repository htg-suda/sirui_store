package com.htg.good.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.entity.good.SpuGoodSpecValue;

import java.util.List;

/**
 * <p>
 * 商品spu规格值表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
public interface ISpuGoodSpecValueService extends IService<SpuGoodSpecValue> {

    List<SpuGoodSpecValue> selectBySpuId(Integer spuId);
}
