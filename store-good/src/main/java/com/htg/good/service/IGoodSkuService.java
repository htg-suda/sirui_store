package com.htg.good.service;

import com.htg.common.dto.good.shop.ShopAddGoodSkuDto;
import com.htg.common.entity.good.GoodSku;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.vo.good.shop.ShopGoodSkuDetailVo;
import com.htg.common.vo.good.shop.ShopGoodSkuVo;
import com.htg.good.exception.GlobalException;

/**
 * <p>
 * 商品的sku 表,具体到某一款商品 服务类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface IGoodSkuService extends IService<GoodSku> {

    CommonResult<RespId> addGoodSku(ShopAddGoodSkuDto goodSku) throws GlobalException;


    CommonResult<RespList<ShopGoodSkuVo>> listBySpuId(Integer spuId);

    CommonResult<ShopGoodSkuDetailVo> detailSku(Integer skuId);
}
