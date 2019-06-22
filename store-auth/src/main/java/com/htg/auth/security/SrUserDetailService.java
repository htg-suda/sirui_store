package com.htg.auth.security;

import com.htg.auth.service.IGroupPermissionMappingService;
import com.htg.auth.service.IPermissionService;
import com.htg.common.bo.user.SrUserBO;
import com.htg.common.details.SrUserDetails;
import com.htg.common.entity.auth.GroupPermissionMapping;
import com.htg.common.entity.auth.Permission;
import com.htg.feign.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class SrUserDetailService implements UserDetailsService {
    @Autowired
    private UserClient userClient;

    @Autowired
    private IGroupPermissionMappingService groupPermissionMappingService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(username);
        SrUserBO srUserBo = userClient.getUserByName(username);
        log.info("user is {}", srUserBo);
        List<Integer> groupIdList = srUserBo.getGroupIdList();

        Integer id = srUserBo.getId();
        Integer age = srUserBo.getAge();
        Integer delFlag = srUserBo.getDelFlag();
        String email = srUserBo.getEmail();
        Integer status = srUserBo.getStatus();
        String tel = srUserBo.getTel();
        Integer gender = srUserBo.getGender();
        String nikename = srUserBo.getNikename();
        String password = srUserBo.getPassword();


        /* 通过 group id 去查找 */
        List<GroupPermissionMapping> mappings = groupPermissionMappingService.selectByGroupIdList(groupIdList);

        List<Integer> permissionIds = new ArrayList<>();
        for (GroupPermissionMapping mapping : mappings) {
            permissionIds.add(mapping.getPermissionId());
        }
        log.info("permissionIds is {}", permissionIds);

        List<Permission> permissions = permissionService.selectBatchIds(permissionIds);

        log.info("permissions is {}", permissions);
        permissions.forEach((v) -> {
            log.info(v.toString());
        });

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Permission permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission.getCode()));
        }

        SrUserDetails srUserDetails = new SrUserDetails(username, password, authorities, id, nikename, tel, email, age, gender
                , status, delFlag
        );

        return srUserDetails;
    }
}
