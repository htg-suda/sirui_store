package com.htg.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://juejin.im/post/5b1922cdf265da6e173a51ec
 */

/**
 * Swagger2API文档的配置
 * Created by macro on 2018/4/26.
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        /* 在Swagger 中添加 请求头 */

        //添加head参数start
        ParameterBuilder tokenParamBuilder = new ParameterBuilder();
        List<Parameter> params = new ArrayList<Parameter>();
        ModelRef modelRef = new ModelRef("string");

        tokenParamBuilder
                .name("Authorization")
                .description("token令牌")
                .modelRef(modelRef)
                .parameterType("header")
                .defaultValue("token_")
                .required(false);
        params.add(tokenParamBuilder.build());
        //添加head参数end


        return new Docket(DocumentationType.SWAGGER_2)  // 配置 生成的文档格式是 Swagger2 的文档格式
                .apiInfo(apiInfo())     // 配置 API 的一些信息
                .select()               // 推断 base 包下的所有的请求
                .apis(RequestHandlerSelectors.basePackage("com.htg"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(params);
    }

    /* 返回一个文档的基本信息*/
    private ApiInfo apiInfo() {
        // 定义联系人信息
        Contact contact = new Contact("htg", "https://www.hstudio.com", "1250068829@qq.com");

        return new ApiInfoBuilder()
                .title("store系统")
                .description("store系统")
                .version("1.0").contact(contact)
                .build();
    }
}
