package com.htg.auth.security;

import com.htg.common.details.LoginUserInfo;
import com.htg.common.details.SrUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.*;

/* 授权服务器 */
@Slf4j
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private SrUserDetailService userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /* 用来配置令牌端点(Token Endpoint)的安全约束. */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // super.configure(security);

        /* 允许表单认证*/
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }


    /*
        用来配置客户端详情服务（ClientDetailsService），
        客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
    */
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
                .authorizedGrantTypes("client_credentials", "refresh_token", "password")
                .scopes("app")
                .accessTokenValiditySeconds(3600)
        ;


        // 除了上面的配置方式我们还可以配置 一个 ClientDetailsService  进行配置

      /*  ClientDetailsService clientDetailsService = new ClientDetailsService() {
            @Override
            public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
                return null;
            }
        };*/
        //  clients.withClientDetails(clientDetailsService);

    }

    // 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancer tokenEnhancer = new TokenEnhancer() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                log.info("========================> authentication {}", authentication);
                SrUserDetails userDetails = (SrUserDetails) authentication.getPrincipal();
                Map<String, Object> additionalInfo = new HashMap<>();

                additionalInfo.put("username", userDetails.getUsername());
                additionalInfo.put("age", userDetails.getAge());
                additionalInfo.put("id", userDetails.getId());
                additionalInfo.put("status", userDetails.getStatus());
                additionalInfo.put("gender", userDetails.getGender());
                additionalInfo.put("del_flag", userDetails.getDelFlag());
                // 注意添加的额外信息，最好不要和已有的json对象中的key重名，容易出现错误
                //additionalInfo.put("authorities", user.getAuthorities());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
                return accessToken;
            }
        };


//      将增强的token设置到增强链中
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        enhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer));

        //* 配置认证管理器 *//
        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
        DefaultUserAuthenticationConverter converter = new DefaultUserAuthenticationConverter() {
            @Override
            public Map<String, ?> convertUserAuthentication(Authentication authentication) {
                Map<String, Object> response = new LinkedHashMap<String, Object>();
                /* 获取 用户详细 的*/
                SrUserDetails userDetails = (SrUserDetails) authentication.getPrincipal();
                /* 这里将 username 设置 为 userDetail */
                LoginUserInfo userInfo = new LoginUserInfo();
                log.info("=============> login user info is {}",userInfo);
                BeanUtils.copyProperties(userDetails, userInfo);
                response.put(USERNAME, userInfo);

                if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
                    response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
                }

                return response;
            }

            @Override
            public Authentication extractAuthentication(Map<String, ?> map) {
                return super.extractAuthentication(map);
            }
        };
        defaultAccessTokenConverter.setUserTokenConverter(converter);


        endpoints.authenticationManager(authenticationManager);
        // Spring Security Oauth2 存储Token的方式有多种, 比如JWT,Jdbc(数据库),Redis等 ...根据Oauth2继承类图

        /* https://blog.csdn.net/liuyanglglg/article/details/89077855 */

        /* TokenStore有很多:
             InMemoryTokenStore;
             JdbcTokenStore;
             JwkTokenStore;
             RedisTokenStore;
             JwtTokenStore;  */
        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory) {
            @Override
            public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
                User user = (User) authentication.getPrincipal();
                log.info("getAccessToken user is {}", user.toString());
                return super.getAccessToken(authentication);
            }

            @Override
            public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
                log.info("getAccessToken clientId is {}", clientId);
                return super.findTokensByClientId(clientId);
            }
        }).userDetailsService(userDetailService).accessTokenConverter(defaultAccessTokenConverter).tokenEnhancer(enhancerChain);



    /*    endpoints.tokenEnhancer(new TokenEnhancer() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                return null;
            }
        });
*/


    /*
       // 添加 jwt 转换器
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123456");
        endpoints.accessTokenConverter(converter);
        */


        /*  自定义token 生成后的的动作 */
       /* endpoints.tokenServices(new AuthorizationServerTokenServices() {
            @Override
            public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) throws AuthenticationException {
                User user = (User) authentication.getPrincipal();
                log.info("user is {}", user.toString());

                return null;
            }

            @Override
            public OAuth2AccessToken refreshAccessToken(String refreshToken, TokenRequest tokenRequest) throws AuthenticationException {

                return null;
            }

            @Override
            public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
                User user = (User) authentication.getPrincipal();
                log.info("user is {}", user.toString());
                return null;
            }
        });*/


        DefaultTokenServices defaultTokenServices = new DefaultTokenServices() {
        };

        /* 配置授权码模式 */
        // endpoints.authorizationCodeServices()
        /* */
        //endpoints.authorizationCodeServices()

        /*
        *默认的 endPoints 的url地址
          /oauth/authorize：授权端点。
          /oauth/token：令牌端点。
          /oauth/confirm_access：用户确认授权提交端点。
          /oauth/error：授权服务错误信息端点。
          /oauth/check_token：用于资源服务访问的令牌解析端点。
          /oauth/token_key：提供公有密匙的端点，如果你使用JWT令牌的话。
        *
        * */
        /* 覆盖原来的 /oauth/token*/
        endpoints.pathMapping("/oauth/token", "/user/login");
    }


}