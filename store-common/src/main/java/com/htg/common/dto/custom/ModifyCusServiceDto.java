package com.htg.common.dto.custom;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModifyCusServiceDto {
    @NotNull(message = "客服ID,不可为空")
    @ApiModelProperty(value = "客服ID", example = "5")
    private Integer cusServiceId;

    @NotBlank(message = "客服昵称不能为空")
    @ApiModelProperty(value = "客服昵称", example = "小白")
    private String cusName;


    public Integer getCusServiceId() {
        return cusServiceId;
    }

    public void setCusServiceId(Integer cusServiceId) {
        this.cusServiceId = cusServiceId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
}
