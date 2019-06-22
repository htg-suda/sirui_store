package com.htg.good.service;

import com.htg.common.dto.good.shop.ShopAddGoodSkuDto;
import com.htg.common.dto.good.user.UserSkuQuery;
import com.htg.common.entity.good.GoodSku;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.result.RespPage;
import com.htg.common.vo.good.shop.ShopGoodSkuDetailVo;
import com.htg.common.vo.good.shop.ShopGoodSkuVo;
import com.htg.common.exception.GlobalException;
import com.htg.common.vo.good.user.UserGoodSkuDetailVo;
import com.htg.common.vo.good.user.UserGoodSkuVo;
import com.htg.common.vo.good.user.UserQuerySkuVo;

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

    CommonResult<RespPage<UserQuerySkuVo>> listByQuery(UserSkuQuery userSkuQuery);

    CommonResult<UserGoodSkuVo> getUserSkuByNum(String sku_num) throws GlobalException;

    /* 列出 sku */
    CommonResult<UserGoodSkuDetailVo> getUserSkuDetail(String skuNum) throws GlobalException;
}
