package com.htg.file.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
 * 资源有:
 * 1,用户头像
 * 2,商户logo
 * 3,店铺logo
 * 4,商店logo
 * */


@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 共有资源 ,任意人都可以访问的数据*/
        registry.addResourceHandler("/category_icon/**").addResourceLocations("file:/home/htg/work/temp/sirui_store_file/res/public/img/category/icon/");


        registry.addResourceHandler("/res/private/img/category/**").addResourceLocations("file:/home/htg/work/temp/sirui_store_file/res/private/img/category/");
        registry.addResourceHandler("/res/private/img/brand/**").addResourceLocations("file:/home/htg/work/temp/sirui_store_file/res/private/img/brand/");
        registry.addResourceHandler("/res/private/img/shop/**").addResourceLocations("file:/home/htg/work/temp/sirui_store_file/res/private/img/shop/");
        registry.addResourceHandler("/res/private/img/good/**").addResourceLocations("file:/home/htg/work/temp/sirui_store_file/res/private/img/good/");
        registry.addResourceHandler("/res/private/img/user/**").addResourceLocations("file:/home/htg/work/temp/sirui_store_file/res/private/img/user/");
        registry.addResourceHandler("/res/private/img/admin/**").addResourceLocations("file:/home/htg/work/temp/sirui_store_file/res/private/img/admin/");
    }
}