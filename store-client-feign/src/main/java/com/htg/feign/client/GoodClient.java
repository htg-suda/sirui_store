package com.htg.feign.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "store-good")
public interface GoodClient {

}
