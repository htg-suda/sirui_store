package com.htg.auth.security;

import com.htg.common.entity.Admin;
import com.htg.feign.client.AdminClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class AdminUserDetailService implements UserDetailsService {
    @Autowired
    private AdminClient adminClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(username);
        Admin admin = adminClient.getUserByName(username);
        log.info("admin is {}",admin);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        return new User(username, admin.getAdminPassword(), authorityList);
    }
}
