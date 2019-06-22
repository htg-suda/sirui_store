package com.htg.auth.security.mobile;

import com.htg.common.constant.CodeConst;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.concurrent.TimeUnit;

//用户认证所在类
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {


    private StringRedisTemplate redisTemplate;

    // 注意这里的userdetailservice ，因为SmsCodeAuthenticationProvider类没有@Component
    // 所以这里不能加@Autowire，只能通过外面设置才行
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 在这里认证用户信息
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
//        String mobile = (String) authenticationToken.getPrincipal();
        String mobile = authentication.getName();
        String smsCode = (String) authenticationToken.getCredentials();
        //  redisTemplate.opsForValue().set(mobile, smsCode, 10, TimeUnit.MINUTES);
        // String smsCodeFromRedis = (String) redisTemplate.opsForValue().get(mobile);
        if (!checkMsgCode(mobile, smsCode)) {
            throw new InternalAuthenticationServiceException("手机验证码不正确");
        }

        UserDetails user = userDetailsService.loadUserByUsername(mobile);
        if (user == null) {
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }

        SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(user, null, user.getAuthorities());
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }

    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }




    public boolean checkMsgCode(String tel, String msgCode) {
        String key = CodeConst.CODE_PREFIX + tel;
        Long remainTime = redisTemplate.getExpire(key);
        /* 验证码过期后 取值为 -2 */
        if (remainTime > 0) {
            String storeCode = redisTemplate.opsForValue().get(key);
            if (StringUtils.equals(msgCode, storeCode)) {   // redis 中的 code 和 传来的 验证码相同
                redisTemplate.delete(key);                          // 一旦验证成功就删除掉缓存中的验证码
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }


    public StringRedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
