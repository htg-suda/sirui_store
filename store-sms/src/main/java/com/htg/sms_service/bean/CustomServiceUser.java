package com.htg.sms_service.bean;

import io.swagger.annotations.ApiModelProperty;

public class CustomServiceUser {
    @ApiModelProperty("用户手机号码")
    private String tel;
    @ApiModelProperty("用户名")
    private String username;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
