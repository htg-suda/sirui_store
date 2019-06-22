package com.htg.common.vo.good.shop;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import com.htg.common.vo.good.base.SkuGoodSpecValueVo;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商品sku规格值表
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
public class ShopSkuGoodSpecValueVo extends SkuGoodSpecValueVo {
    @ApiModelProperty(value = "是否必填,0-不是, 1-是", example = "1")
    private Integer isNecessary;



    public Integer getIsNecessary() {
        return isNecessary;
    }


    public void setIsNecessary(Integer isNecessary) {
        this.isNecessary = isNecessary;
    }
}
