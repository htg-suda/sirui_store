package com.htg.common.vo.good.base;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商品sku规格值表
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
@TableName("sr_sku_good_spec_value")
public class SkuGoodSpecValueVo extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "通用的规格参数值的id")
    private Integer id;

    @ApiModelProperty(value = "规格参数值,当参数名规定了 numeric 的时候表示是可以转换为数值类型", example = "0.01", required = true)
    private String specValue;


    @ApiModelProperty(value = "商品sku_id", example = "1")
    private Integer skuId;


    @ApiModelProperty(value = "规格参数值,当参数名规定了 numeric 的时候表示是可以转换为数值类型", example = "1", required = true)
    private Integer specItemId;


    @ApiModelProperty(value = "规格参数健值", example = "每天价格")
    private String specItemName;


    @ApiModelProperty(value = "产品分类id", example = "1")
    private Integer categoryId;


    @ApiModelProperty(value = "规格组id", example = "1")
    private Integer groupId;


    @ApiModelProperty(value = "规格值的类型, num-数值类型 , enum 枚举类型 ,str-文本类型,images-图片url地址如xxx.png;xxx.png", example = "1")
    private String specType;


    @ApiModelProperty(value = "如果是枚举类型的话,其各个枚举值,以逗号分割", example = "1")
    private String enumOptions;


    @ApiModelProperty(value = "在为数值类型的时候的单位,比如12mm中的mm", example = "mm")
    private String unit;


    public Integer getId() {
        return id;
    }

    public SkuGoodSpecValueVo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSpecValue() {
        return specValue;
    }

    public SkuGoodSpecValueVo setSpecValue(String specValue) {
        this.specValue = specValue;
        return this;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public SkuGoodSpecValueVo setSkuId(Integer skuId) {
        this.skuId = skuId;
        return this;
    }

    public Integer getSpecItemId() {
        return specItemId;
    }

    public SkuGoodSpecValueVo setSpecItemId(Integer specItemId) {
        this.specItemId = specItemId;
        return this;
    }

    public String getSpecItemName() {
        return specItemName;
    }

    public SkuGoodSpecValueVo setSpecItemName(String specItemName) {
        this.specItemName = specItemName;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public SkuGoodSpecValueVo setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public SkuGoodSpecValueVo setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getSpecType() {
        return specType;
    }

    public SkuGoodSpecValueVo setSpecType(String specType) {
        this.specType = specType;
        return this;
    }

    public String getEnumOptions() {
        return enumOptions;
    }

    public SkuGoodSpecValueVo setEnumOptions(String enumOptions) {
        this.enumOptions = enumOptions;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public SkuGoodSpecValueVo setUnit(String unit) {
        this.unit = unit;
        return this;
    }


    @Override
    public String toString() {
        return "SkuGoodSpecValue{" +
        "id=" + id +
        ", specValue=" + specValue +
        ", skuId=" + skuId +
        ", specItemId=" + specItemId +
        ", specItemName=" + specItemName +
        ", categoryId=" + categoryId +
        ", groupId=" + groupId +
        ", specType=" + specType +
        ", enumOptions=" + enumOptions +
        ", unit=" + unit +
        "}";
    }
}
