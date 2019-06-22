package com.htg.sms_service.bean;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

public class SendBean {
    @Pattern(regexp = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$", message = "用户手机号码不合法")
    @ApiModelProperty(value = "用户手机号码", example = "18717919375")
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "SendBean{" +
                "tel='" + tel + '\'' +
                '}';
    }
}
