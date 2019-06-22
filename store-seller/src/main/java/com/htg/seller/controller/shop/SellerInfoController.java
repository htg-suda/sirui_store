package com.htg.seller.controller.shop;

import com.htg.common.details.LoginUserInfo;
import com.htg.common.dto.seller.shop.SellerAddDto;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.utils.AuthUtil;
import com.htg.common.vo.good.shop.ShopGoodSpuVo;
import com.htg.seller.service.ISellerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;

/**
 * <p>
 * 卖家/商户信息表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
@Slf4j
@Api(value = "SellerInfoController", tags = "商户-商户管理")
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

    /*todo   */
    @ApiOperation(value = "获取店铺内相关的商品")
    @ResponseBody
    @PostMapping("/get_store_spu")
    public CommonResult<RespPage<ShopGoodSpuVo>> getStoreSpuInfo(Integer pageSize, Integer pageNum) throws GlobalException {

        return sellerInfoService.getStoreSpuInfo(pageSize, pageNum);
    }


    @ApiOperation(value = "内部使用--根据用户id获取商户的store")
    @ResponseBody
    @GetMapping("/get_store_by_user_id/{user_id}")
    public SellerStore getSellerStoreByUserId(@PathVariable("user_id") Integer user_id) {
        try {
            return sellerInfoService.getStoreByUserId(user_id);
        } catch (GlobalException e) {
            e.printStackTrace();
        }
        return null;
    }


    @ApiOperation(value = "内部使用--根据用户id获取商户信息")
    @ResponseBody
    @GetMapping("/get_seller_info_by_user_id/{user_id}")
    public SellerInfo getSellerInfoByUserId(@PathVariable("user_id") Integer user_id) {
        try {
            return sellerInfoService.getSellerInfo(user_id);
        } catch (GlobalException e) {
            e.printStackTrace();
        }
        return null;
    }


    @ApiOperation(value = "获取用户信息测试")
    @ResponseBody
    @PostMapping("/test")
    public CommonResult<LoginUserInfo> addStoreInfo() {
        log.info("authUtils is {}", AuthUtil.getLoginUser());
        return CommonResult.success(AuthUtil.getLoginUser());
    }

}

