package com.htg.seller.controller.system;


import com.htg.common.dto.seller.system.SellerListDto;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.seller.system.SysSellerListItem;
import com.htg.seller.service.ISellerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Api(value = "SellerInfoController", tags = "商户-商户管理")
@Validated
@RestController
@RequestMapping("/sys/")
public class SystemSellerController {
    @Autowired
    private ISellerInfoService sellerInfoService;

    /* 查询 商户并且分页 */
    @ApiOperation(value = "资质审核页面查看商户")
    @ResponseBody
    @PostMapping("/seller/list")
    public CommonResult<RespPage<SysSellerListItem>> getSellerList(@Valid @RequestBody SellerListDto listDto) {
        return sellerInfoService.getSellerList(listDto);
    }
}
