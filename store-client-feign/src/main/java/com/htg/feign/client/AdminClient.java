package com.htg.feign.client;


import com.htg.common.entity.admin.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "store-admin")
public interface AdminClient {
    @GetMapping("/admin/{name}")
    Admin getUserByName(@PathVariable("name") String name);
}
