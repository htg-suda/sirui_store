package com.htg.user.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/*配置资源服务器*/
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        /**  authorizeRequests() 后定义多个antMatchers()配置器来控制不同的url接受不同权限的用户访问 */
        /* 允许 oauth 的请求 */
        http.authorizeRequests()
                /* swagger start */
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/configuration/ui").permitAll()
                .antMatchers("/configuration/security").permitAll()
                /* swagger end */
                .antMatchers("/oauth/**").permitAll().
                /*  这里必须允许调用,否则认证中心无法 获取用户 */
                 antMatchers("/user/name/**").permitAll().
                 antMatchers("/user/tel/**").permitAll().
                 antMatchers("/user/email/**").permitAll().

                anyRequest().authenticated();
    }
}
