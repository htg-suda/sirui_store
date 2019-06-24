package com.htg.common.dto.seller.system;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class SellerVerifyDto {

    @NotNull(message = "商户id")
    @ApiModelProperty(value = "商户id", example = "1")
    private Integer sellerId;

    @NotNull(message = "审核状态码不可为空")
    @ApiModelProperty(value = " 0-待审核,1-审核通过,-1 申请未通过 ,10-商户冻结", example = "1")
    private Integer state;


    @ApiModelProperty(value = "冻结原因或申请未通过原因", example = "logo 太难看了啊")
    private String stateRemark;


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateRemark() {
        return stateRemark;
    }

    public void setStateRemark(String stateRemark) {
        this.stateRemark = stateRemark;
    }


    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}
