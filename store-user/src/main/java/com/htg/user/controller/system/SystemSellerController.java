package com.htg.user.controller.system;
import com.htg.common.dto.seller.system.SellerListDto;
import com.htg.common.dto.seller.system.SellerVerifyDto;
import com.htg.common.dto.seller.system.SysSellerAddDto;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.vo.seller.system.SysSellerListItem;
import com.htg.user.service.ISellerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Api(value = "SystemSellerController", tags = "002-管理员-商户管理")
@Validated
@RestController
@RequestMapping("/sys")
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

    /*todo 管理员添加商户 */
    @ApiOperation(value = "添加商户和用户")
    @ResponseBody
    @PostMapping("/seller/add")
    public CommonResult<RespId> addSeller(@Valid @RequestBody  SysSellerAddDto sysSellerAddDto) {
        return sellerInfoService.addSysSeller(sysSellerAddDto);
    }


    /*todo 添加 管理员审核页面 */
    @ApiOperation(value = "管理员审核商户")
    @ResponseBody
    @PostMapping("/seller/verify")
    public CommonResult getSellerList(@Valid @RequestBody SellerVerifyDto verifyDto) {
        return sellerInfoService.verifySellerInfo(verifyDto);
    }




}
