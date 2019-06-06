package com.htg.common.dto.good.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SysVerifyGoodSpuDto {

    @NotNull
    @ApiModelProperty(value = "商品spu id", example = "1")
    private Integer spuId;

    @ApiModelProperty(value = "商品审核 1-通过，0-未通过", example = "1")
    private Integer verify;


    @ApiModelProperty(value = "审核不通过原因", example = "logo 太丑陋,审核不通过")
    private String verifyRemark;

}
