package com.htg.auth.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
@EnableWebSecurity
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminUserDetailService adminUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests().antMatchers("/admin/*").permitAll().anyRequest().authenticated();

    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /*   @Bean
       @Override
       public AuthenticationManager authenticationManagerBean() throws Exception {
           AuthenticationManager authenticationManager = super.authenticationManagerBean();
           return authenticationManager;
       }
   */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String encode = passwordEncoder.encode("123");
      /*  auth.inMemoryAuthentication()
                .withUser("simm").password(encode).roles("USER").and()
                .withUser("admin").password(encode).roles("USER", "ADMIN");*/
        // log.info("==========>" + encode);

      // auth.userDetailsService(adminUserDetailService).passwordEncoder(passwordEncoder);
        super.configure(auth);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

}


