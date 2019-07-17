package com.htg.auth.security.mobile;

import com.htg.auth.security.handler.MyAuthFailureHandler;
import com.htg.auth.security.handler.MyAuthSuccessHandler;
import com.htg.auth.service.IGroupPermissionMappingService;
import com.htg.auth.service.IPermissionService;
import com.htg.common.bo.user.SrUserBO;
import com.htg.common.details.SrUserDetails;
import com.htg.common.entity.auth.GroupPermissionMapping;
import com.htg.common.entity.auth.Permission;
import com.htg.feign.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * * 自定义验证密码或者验证码
 * https://blog.csdn.net/tzdwsy/article/details/50738043
 * https://blog.csdn.net/xiejx618/article/details/42609497
 * https://blog.csdn.net/jiangshanwe/article/details/73842143
 * https://longfeizheng.github.io/2018/01/14/Spring-Security%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90%E4%BA%94-Spring-Security%E7%9F%AD%E4%BF%A1%E7%99%BB%E5%BD%95/
 * https://cloud.tencent.com/developer/article/1040105
 */
@Slf4j
@Component
public class SmsCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private UserClient userClient;


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private IGroupPermissionMappingService groupPermissionMappingService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private MyAuthSuccessHandler authSuccessHandler;

    @Autowired
    private MyAuthFailureHandler authFailureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();

        smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    /*    smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.getWriter().write("oh yeahs !!");
            }
        });*/

        smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(authSuccessHandler);
        smsCodeAuthenticationFilter.setAuthenticationFailureHandler(authFailureHandler);

        SmsCodeAuthenticationProvider smsCodeDaoAuthenticationProvider = new SmsCodeAuthenticationProvider();

        smsCodeDaoAuthenticationProvider.setRedisTemplate(redisTemplate);
        smsCodeDaoAuthenticationProvider.setUserDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String tel) throws UsernameNotFoundException {
                log.info("tel is " + tel);
                SrUserBO srUserBo = userClient.getUserByTel(tel);
                log.info("user is {}", srUserBo);

                if (null == srUserBo) {
                    throw new UsernameNotFoundException("用户未找到...");
                }
                Integer id = srUserBo.getId();
                Integer age = srUserBo.getAge();
                Integer delFlag = srUserBo.getDelFlag();
                String email = srUserBo.getEmail();
                Integer status = srUserBo.getStatus();
                String username = srUserBo.getUsername();
                Integer gender = srUserBo.getGender();
                String nikename = srUserBo.getNikename();
                String password = srUserBo.getPassword() == null ? "" : srUserBo.getPassword();

                /* 通过 group id 去查找 */
                List<Integer> groupIdList = srUserBo.getGroupIdList();
                log.info("groupIdList is {}", groupIdList);
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                if (groupIdList != null && groupIdList.size() > 0) {  // 如果用户有用户组的话
                    List<GroupPermissionMapping> mappings = groupPermissionMappingService.selectByGroupIdList(groupIdList);

                    List<Integer> permissionIds = mappings.stream().map(GroupPermissionMapping::getPermissionId).collect(Collectors.toList());
                    log.info("permissionIds is {}", permissionIds);
                    List<Permission> permissions = permissionService.selectBatchIds(permissionIds);

                    log.info("permissions is {}", permissions);
                    permissions.forEach((v) -> {
                        log.info(v.toString());
                    });
                    authorities.addAll(permissions.stream().map(Permission::getCode).map((code) -> (new SimpleGrantedAuthority(code))).collect(Collectors.toList()));
                }

                authorities.forEach((value) -> {
                    log.info(value.getAuthority());
                });
                SrUserDetails srUserDetails = new SrUserDetails(username, password, authorities, id, nikename, tel, email, age, gender, status, delFlag);
                return srUserDetails;
            }
        });

        http.authenticationProvider(smsCodeDaoAuthenticationProvider).addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
