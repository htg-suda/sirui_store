package com.htg.sms_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SmsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmsServiceApplication.class, args);
    }
}
