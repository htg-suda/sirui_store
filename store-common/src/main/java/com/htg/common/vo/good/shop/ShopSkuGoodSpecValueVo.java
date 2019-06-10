package com.htg.common.vo.good.shop;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import com.htg.common.vo.good.base.SkuGoodSpecValueVo;

/**
 * <p>
 * 商品sku规格值表
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
@TableName("sr_sku_good_spec_value")
public class ShopSkuGoodSpecValueVo extends SkuGoodSpecValueVo {
    /**
     * 是否必填,0-不是, 1-是
     */
    @TableField("is_necessary")
    private Integer isNecessary;



    public Integer getIsNecessary() {
        return isNecessary;
    }


    public void setIsNecessary(Integer isNecessary) {
        this.isNecessary = isNecessary;
    }
}
