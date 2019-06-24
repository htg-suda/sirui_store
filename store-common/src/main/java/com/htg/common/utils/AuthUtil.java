package com.htg.common.utils;

import com.htg.common.details.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.LinkedHashMap;

@Slf4j
public class AuthUtil {
    public static LoginUserInfo getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("=========>{}", authentication);
        log.info("=========>{}", authentication.getPrincipal());
        LinkedHashMap<String, Object> map = (LinkedHashMap) authentication.getPrincipal();
        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setId((Integer) map.get("id"));
        userInfo.setUsername((String) map.get("username"));
        return userInfo;
    }

    public static Integer getLoginUserId() {

        return getLoginUser().getId();
    }


    public static String getLoginUserUserName() {

        return getLoginUser().getUsername();
    }
}
