package com.htg.good.controller.test;

import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.result.CommonResult;
import com.htg.feign.client.SellerClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "TestController", tags = "token 测试 模块")
@Validated
@RestController
@RequestMapping("/user/spu")
public class TestController {
    @Autowired
    private SellerClient sellerClient;

    /*列表 spu */
    @ApiOperation(value = "测试client")
    @ResponseBody
    @GetMapping("/test")
    public CommonResult<SellerInfo> testClient(Integer user_id) {
        return CommonResult.success(sellerClient.getSellerInfoByUserId(user_id));
    }

    /*列表 spu */
    @ApiOperation(value = "测试client")
    @ResponseBody
    @GetMapping("/test01")
    public CommonResult<SellerStore> testClient01(Integer user_id) {
        return CommonResult.success(sellerClient.getSellerStoreByUserId(user_id));
    }
}
