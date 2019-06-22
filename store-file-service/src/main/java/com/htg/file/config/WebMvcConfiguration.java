package com.htg.file.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collection;
/*
 * 资源有:
 * 1,用户头像
 * 2,商户logo
 * 3,店铺logo
 * 4,商店logo
 * */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private FileConfig fileConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String globalPath = fileConfig.getGlobal_path();
        String publicRes = fileConfig.getPublic_res();
        String filePathPrefix = "file:" + globalPath + publicRes;
      /*  Collection<String> pathUrlList = fileConfig.getPub_res_map().values();
        for (String pathUrl : pathUrlList) {
            registry.addResourceHandler(pathUrl + "**").addResourceLocations(filePathPrefix + pathUrl);
        }*/
        registry.addResourceHandler("/file/pub/**").addResourceLocations(filePathPrefix+"/");
        /* 共有资源 ,任意人都可以访问的数据*/
        // registry.addResourceHandler("/category/img/**").addResourceLocations(filePathPrefix + "/category/img/");
        // registry.addResourceHandler("/user/img/**").addResourceLocations(filePathPrefix + "/user/img/");
        // registry.addResourceHandler("/good/img/**").addResourceLocations(filePathPrefix + "/good/img/");
        // registry.addResourceHandler("/shop/img/**").addResourceLocations(filePathPrefix + "/shop/img/");
        // registry.addResourceHandler("/admin/img/**").addResourceLocations(filePathPrefix + "/admin/img/");
    }

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }*/
}