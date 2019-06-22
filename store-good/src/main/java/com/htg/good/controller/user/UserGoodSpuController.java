package com.htg.good.controller.user;

import com.htg.common.dto.good.user.UserGoodSpuListDto;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.good.user.UserGoodSpuDetailVo;
import com.htg.common.vo.good.user.UserGoodSpuVo;
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

@Slf4j
@Api(value = "UserGoodSpuController", tags = "用户001-商品spu模块")
@Validated
@RestController
@RequestMapping("/user/spu")
public class UserGoodSpuController {
    @Autowired
    private IGoodSpuService goodSpuService;
    /*列表 spu */
    @ApiOperation(value = "列出商品spu")
    @ResponseBody
    @PostMapping("/list")
    public CommonResult<RespPage<UserGoodSpuVo>> listGoodSpu(@Valid @RequestBody UserGoodSpuListDto goodSpuListDto) {
        return goodSpuService.list(goodSpuListDto);
    }

    @ApiOperation(value = "获取商品spu详情")
    @ResponseBody
    @GetMapping("/detail/{spuId}")
    public CommonResult<UserGoodSpuDetailVo> getShopGoodSpuDetailById(@NotNull(message = "spu id不能为空") @PathVariable Integer spuId) throws GlobalException {
        return goodSpuService.getUserGoodSpuDetailById(spuId);
    }


}
