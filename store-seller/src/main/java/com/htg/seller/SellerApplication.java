package com.htg.seller;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.htg")
@EnableDiscoveryClient
@MapperScan("com.htg.seller.mapper")
@SpringBootApplication
public class SellerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class);
    }
}
