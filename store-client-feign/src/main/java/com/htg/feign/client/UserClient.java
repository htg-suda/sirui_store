package com.htg.feign.client;

import com.htg.common.bo.user.SrUserBO;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.feign.client.config.FeignSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "store-user",configuration = FeignSupportConfig.class)
public interface UserClient {
    @GetMapping("/user/name/{name}")
    SrUserBO getUserByName(@PathVariable("name") String name);


    @GetMapping("/user/tel/{tel}")
    SrUserBO getUserByTel(@PathVariable("tel") String tel);


    @GetMapping("/user/email/{email}")
    SrUserBO getUserByEmail(@PathVariable("email") String email);

    @GetMapping("/seller_info/get_seller_info_by_user_id/{user_id}")
    SellerInfo getSellerInfoByUserId(@PathVariable("user_id") Integer user_id);


    @GetMapping("/seller_info/get_store_by_user_id/{user_id}")
    SellerStore getSellerStoreByUserId(@PathVariable("user_id") Integer user_id);
}
