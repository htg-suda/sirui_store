package com.htg.user.controller.inner;

import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.exception.GlobalException;
import com.htg.user.service.ISellerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "SellerInnerController", tags = "999-内部商户API")
@Validated
@RestController
@RequestMapping("/seller_info")
public class SellerInnerController {
    @Autowired
    private ISellerInfoService sellerInfoService;

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
}
