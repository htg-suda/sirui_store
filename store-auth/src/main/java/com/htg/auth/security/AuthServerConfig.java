package com.htg.auth.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/* 授权服务器 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private AdminUserDetailService userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // super.configure(security);

        /* 允许表单认证*/
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }


    /* 配置客户端详情信息（Client Details)*/
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /// super.configure(clients);
        /*配置客户端 clientId system
         * 配置secret system
         * 配置 模式 password
         *  client_id=system&secret=system&grant_type=password&scopes=app&username=johndoe&password=A3ddj3w
         * */
        clients.inMemory().withClient("system")
                .secret(passwordEncoder.encode("system"))
                .authorizedGrantTypes("client_credentials", "refresh_token","password")
                .scopes("app")
                .accessTokenValiditySeconds(3600);
    }

    /* 配置节点 */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        /* 配置认证管理器 */

        endpoints.authenticationManager(authenticationManager);
        // Spring Security Oauth2 存储Token的方式有多种, 比如JWT,Jdbc(数据库),Redis等 ...根据Oauth2继承类图

        /* https://blog.csdn.net/liuyanglglg/article/details/89077855 */

        /* TokenStore有很多:
             InMemoryTokenStore;
             JdbcTokenStore;
             JwkTokenStore;
             RedisTokenStore;
             JwtTokenStore;  */
        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory)).userDetailsService(userDetailService);
        /* 配置授权码模式 */
        // endpoints.authorizationCodeServices()
        /* */
        //endpoints.authorizationCodeServices()
    }


}