package com.htg.common.vo.good.shop;

import com.baomidou.mybatisplus.annotations.TableField;
import com.htg.common.vo.good.base.SpuGoodSpecValueVo;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class ShopSpuGoodSpecValueVo extends SpuGoodSpecValueVo {


    @ApiModelProperty(value = "是否必填,0-不是, 1-是", example = "1")
    private Integer isNecessary;

    public Integer getIsNecessary() {
        return isNecessary;
    }

    public void setIsNecessary(Integer isNecessary) {
        this.isNecessary = isNecessary;
    }
}
