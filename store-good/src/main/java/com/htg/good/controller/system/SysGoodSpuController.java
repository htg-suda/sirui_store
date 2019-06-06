package com.htg.good.controller.system;

import com.htg.common.dto.good.shop.GoodSpuListDto;
import com.htg.common.dto.good.system.SysModifyGoodSpuStateDto;
import com.htg.common.dto.good.system.SysVerifyGoodSpuDto;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.vo.good.shop.ShopGoodSpuDetailVo;
import com.htg.common.vo.good.shop.ShopGoodSpuVo;
import com.htg.good.exception.GlobalException;
import com.htg.good.service.IGoodSpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@Api(value = "SysGoodSpuController", tags = "系统006-商品spu管理")
@Validated
@RestController
@RequestMapping("/sys/spu")
public class SysGoodSpuController {
    @Autowired
    private IGoodSpuService goodSpuService;

    /* */
    /* 修改商品 SPU */
    @ApiOperation(value = "审核商品")
    @ResponseBody
    @PostMapping("/verify")
    public CommonResult<RespId> modifyGoodSpu(@Valid @RequestBody SysVerifyGoodSpuDto verifyGoodSpuDto) throws GlobalException {
        return goodSpuService.modify(verifyGoodSpuDto);
    }

    /* */
    /* 修改商品 SPU */
    @ApiOperation(value = "禁售,解禁商品")
    @ResponseBody
    @PostMapping("/modify_state")
    public CommonResult<RespId> modifyGoodSpu(@Valid @RequestBody SysModifyGoodSpuStateDto modifyState) throws GlobalException {
        return goodSpuService.modify(modifyState);
    }


    /*列表 spu */
    @ApiOperation(value = "列出商品spu")
    @ResponseBody
    @PostMapping("/list")
    public CommonResult<RespPage<ShopGoodSpuVo>> listGoodSpu(@Valid @RequestBody GoodSpuListDto goodSpuListDto) {
        return goodSpuService.list(goodSpuListDto);
    }

    @ApiOperation(value = "获取商品spu详情")
    @ResponseBody
    @GetMapping("/detail/{spuId}")
    public CommonResult<ShopGoodSpuDetailVo> getShopGoodSpuDetailById(@NotNull(message = "spu id不能为空") @PathVariable Integer spuId) throws GlobalException {
        return goodSpuService.getShopGoodSpuDetailById(spuId);
    }
}
