package com.htg.good.controller.shop;

import com.htg.common.dto.good.shop.GoodSpuListDto;
import com.htg.common.dto.good.shop.ShopAddGoodSpuDto;
import com.htg.common.dto.good.shop.ShopModifyGoodSpuDto;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.utils.AuthUtil;
import com.htg.common.vo.good.shop.ShopGoodSpuDetailVo;
import com.htg.common.vo.good.shop.ShopGoodSpuVo;
import com.htg.common.exception.GlobalException;
import com.htg.good.service.IGoodSpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * <p>
 * 商品spu表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Slf4j
@Api(value = "GoodSpuController", tags = "商户001-商品spu管理")
@Validated
@RestController
@RequestMapping("/shop/spu")
public class GoodSpuController {
    @Autowired
    private IGoodSpuService goodSpuService;

    @ApiOperation(value = "添加商品SPU")
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addGoodSpu(@Valid @RequestBody ShopAddGoodSpuDto goodSpu) throws GlobalException {
        return goodSpuService.addGoodSpu(goodSpu);
    }
    /* 修改spu*/

    /* 修改商品 SPU */
    @ApiOperation(value = "修改商品SPU")
    @ResponseBody
    @PostMapping("/modify")
    public CommonResult<RespId> modifyGoodSpu(@Valid @RequestBody ShopModifyGoodSpuDto goodSpuModifyDto) throws GlobalException {
        return goodSpuService.modify(goodSpuModifyDto);
    }

    /*列表 spu */
    @ApiOperation(value = "列出商品spu")
    @ResponseBody
    @PostMapping("/list")
    public CommonResult<RespPage<ShopGoodSpuVo>> listGoodSpu(@Valid @RequestBody GoodSpuListDto goodSpuListDto) throws GlobalException {
        SellerInfo info = goodSpuService.checkSellerInfo(AuthUtil.getLoginUserId());
        SellerStore sellerStore = goodSpuService.checkSellerStore(AuthUtil.getLoginUserId());
        return goodSpuService.list(goodSpuListDto, sellerStore.getId());
    }

    @ApiOperation(value = "获取商品spu详情")
    @ResponseBody
    @GetMapping("/detail/{spuId}")
    public CommonResult<ShopGoodSpuDetailVo> getShopGoodSpuDetailById(@NotNull(message = "spu id不能为空") @PathVariable Integer spuId) throws GlobalException {
        return goodSpuService.getShopGoodSpuDetailById(spuId);
    }


}

