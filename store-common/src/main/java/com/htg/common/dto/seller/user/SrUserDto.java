package com.htg.common.dto.seller.user;

import com.htg.common.entity.user.SrUser;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class SrUserDto extends SrUser {
    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "短信验证码", example = "888888")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
