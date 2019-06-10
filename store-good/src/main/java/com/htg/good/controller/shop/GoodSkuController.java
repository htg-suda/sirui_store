package com.htg.good.controller.shop;


import com.htg.common.dto.good.shop.ShopAddGoodSkuDto;
import com.htg.common.entity.good.GoodSku;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.result.RespPage;
import com.htg.common.vo.good.shop.ShopGoodSkuDetailVo;
import com.htg.common.vo.good.shop.ShopGoodSkuVo;
import com.htg.good.exception.GlobalException;
import com.htg.good.service.IGoodSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 商品的sku 表,具体到某一款商品 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Slf4j
@Api(value = "GoodSkuController", tags = "商户002-商品SKU管理")
@Validated
@RestController
@RequestMapping("/shop/good_sku")
public class GoodSkuController {
    private IGoodSkuService skuService;

    @ApiOperation(value = "添加商品SKU")
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addGoodSku(@Valid @RequestBody ShopAddGoodSkuDto goodSku) throws GlobalException {
        return skuService.addGoodSku(goodSku);
    }

    @ApiOperation(value = "列出商品SKU")
    @ResponseBody
    @PostMapping("/list/{spuId}")
    public CommonResult<RespList<ShopGoodSkuVo>> listSkuBySpuId(@PathVariable Integer spuId) {
        return skuService.listBySpuId(spuId);
    }


    @ApiOperation(value = "获取SKU详情")
    @ResponseBody
    @PostMapping("/detail/{skuId}")
    public CommonResult<ShopGoodSkuDetailVo> detailSku(@PathVariable Integer skuId) {
        return skuService.detailSku(skuId);
    }


    /* 修改 sku */
}

