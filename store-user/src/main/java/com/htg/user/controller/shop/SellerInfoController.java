package com.htg.user.controller.shop;

import com.htg.common.details.LoginUserInfo;
import com.htg.common.dto.seller.shop.SellerAddDto;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.utils.AuthUtil;
import com.htg.common.vo.seller.shop.SellerInfoDetailsVo;
import com.htg.common.vo.user.admin.CustomServiceUserInfoVo;
import com.htg.user.service.ISellerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * <p>
 * 卖家/商户信息表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
@Slf4j
@Api(value = "SellerInfoController", tags = "003-商户-商户管理")
@Validated
@RestController
@RequestMapping("/seller_info")
public class SellerInfoController {
    /* 添加 商户信息 */
    @Autowired
    private ISellerInfoService sellerInfoService;


    @ApiOperation(value = "普通用户添加为商家")
    @ResponseBody
    @PostMapping("/add_seller")
    public CommonResult<RespId> addStoreInfo(@Valid @RequestBody SellerAddDto sellerAddDto) throws GlobalException {
        LoginUserInfo loginUser = AuthUtil.getLoginUser();
        sellerAddDto.getSellerInfo().setUserId(loginUser.getId());
        return sellerInfoService.addSeller(sellerAddDto);
    }


    @ApiOperation(value = "审核通过后的商家创建商铺")
    @ResponseBody
    @PostMapping("/add_store")
    public CommonResult<RespId> addStoreInfo(@Valid @RequestBody SellerStore sellerStore) throws GlobalException {
        return sellerInfoService.addStore(sellerStore);
    }


    /* 获取用户的卖家信息 */
    @ApiOperation(value = "获取用户的卖家信息")
    @ResponseBody
    @PostMapping("/get_seller_info_details")
    public CommonResult<SellerInfoDetailsVo> getSellerInfoDetails() throws GlobalException {
         Integer userId = AuthUtil.getLoginUserId();
        return sellerInfoService.getSellerInfoDetails(userId);
    }


    @ApiOperation(value = "获取用户信息测试")
    @ResponseBody
    @PostMapping("/test")
    public CommonResult<LoginUserInfo> addStoreInfo() {
        log.info("authUtils is {}", AuthUtil.getLoginUser());
        return CommonResult.success(AuthUtil.getLoginUser());
    }


}

