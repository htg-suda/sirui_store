package com.htg.common.dto.good.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


@Data
public class SysModifyGoodSpuStateDto {
    @NotNull(message = "商品spu id 不能为空")
    @ApiModelProperty(value = "商品spu id", example = "1")
    private Integer spuId;

    @NotNull(message = "SPU 状态不能为空")
    @ApiModelProperty(value = "商品状态: 0-下架(商家行为), 1-上架在售, 2-待售卖 ,10-违规被禁止售卖(管理员行为),一旦禁止售卖则无法上架,20-解禁,解禁后可以重新上架")
    private Integer state;


    @Length(max = 100, message = "违规原因字数不能超过100")
    @ApiModelProperty(value = "违规原因")
    private String stateRemark;


}
