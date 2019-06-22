package com.htg.common.details;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SrUserDetails extends User {
    private Integer id;

    private String username;

    private String password;

    private String nikename;

    private String tel;

    private String email;

    private Integer age;

    private Integer gender;

    @ApiModelProperty(value = "用户状态 1001-可用, 1002-不可用", example = "1001")
    private Integer status;


    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", example = "0")
    private Integer delFlag;

    private Collection<? extends GrantedAuthority> authorities;


    public SrUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Integer id, String nikename, String tel, String email, Integer age, Integer gender, Integer status, Integer delFlag) {
        super(username, password, authorities);
        this.id = id;
        this.username = username;
        this.password = password;
        this.nikename = nikename;
        this.tel = tel;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.delFlag = delFlag;
        this.authorities = authorities;
    }

    public SrUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public SrUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "SrUserDetails{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nikename='" + nikename + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", status=" + status +
                ", delFlag=" + delFlag +
                ", authorities=" + authorities +
                '}';
    }
}
