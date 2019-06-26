package com.htg.auth.security;
import com.htg.auth.security.mobile.SmsCodeAuthenticationSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

/*配置资源服务器*/
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /* 允许 oauth 的请求 */

        http.cors().and().csrf().disable();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry
                = http.authorizeRequests();
        registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();//让Spring security放行所有preflight request


        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/**").permitAll()
                /* swagger start */
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/configuration/ui").permitAll()
                .antMatchers("/configuration/security").permitAll()
                /* swagger end */
                .antMatchers("/oauth/**").permitAll()

                .antMatchers("/user/login").permitAll()
                .antMatchers("/oauth/token").permitAll()
                /* 手机号码登录 */
                .antMatchers("/mobile/login").permitAll()
                .anyRequest().authenticated();
        http.apply(smsCodeAuthenticationSecurityConfig);
    }
}
