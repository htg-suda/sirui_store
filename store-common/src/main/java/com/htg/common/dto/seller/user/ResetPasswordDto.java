package com.htg.common.dto.seller.user;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ResetPasswordDto {
    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$",
            message = "用户手机号码不合法")
    @ApiModelProperty(value = "用户手机号码", example = "18717919375")
    private String tel;
    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "短信验证码", example = "888888")
    private String smsCode;

    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "密码必须是字母和数字的组合,且位数为6~20位")
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "用户密码", example = "123qwe")
    private String newPass;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
