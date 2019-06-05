package com.htg.good;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.htg.good.mapper")
@SpringBootApplication
public class StoreGoodApplication  {
    public static void main(String[] args) {
        SpringApplication.run(StoreGoodApplication.class);
    }
}
