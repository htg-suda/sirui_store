package com.htg.common.entity.good;

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
public class SkuGoodSpecValue extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "通用的规格参数值的id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "规格参数值不可为空")
    @ApiModelProperty(value = "规格参数值,当参数名规定了 numeric 的时候表示是可以转换为数值类型", example = "0.01", required = true)
    @TableField("spec_value")
    private String specValue;


    @ApiModelProperty(value = "商品sku_id", example = "1", hidden = true)
    @TableField("sku_id")
    private Integer skuId;


    @NotNull(message = "规格参数值不可为空")
    @ApiModelProperty(value = "规格参数值,当参数名规定了 numeric 的时候表示是可以转换为数值类型", example = "1", required = true)
    @TableField("spec_item_id")
    private Integer specItemId;


    @NotBlank(message = "规格参数名不可为空")
    @ApiModelProperty(value = "规格参数健值", example = "每天价格")
    @TableField("spec_item_name")
    private String specItemName;


    @NotBlank(message = "产品分类id 不可为空")
    @ApiModelProperty(value = "产品分类id", example = "1")
    @TableField("category_id")
    private Integer categoryId;


    @NotNull(message = "规格组id不可为空")
    @ApiModelProperty(value = "规格组id", example = "1")
    @TableField("group_id")
    private Integer groupId;


    @NotBlank(message = "规格值的类型不可为空")
    @ApiModelProperty(value = "规格值的类型, num-数值类型 , enum 枚举类型 ,str-文本类型,images-图片url地址如xxx.png;xxx.png", example = "1")
    @TableField("spec_type")
    private String specType;


    @ApiModelProperty(value = "如果是枚举类型的话,其各个枚举值,以逗号分割", example = "1")
    @TableField("enum_options")
    private String enumOptions;


    @ApiModelProperty(value = "在为数值类型的时候的单位,比如12mm中的mm", example = "mm")
    @TableField("unit")
    private String unit;


    @NotNull(message = "是否必填不可为空")
    @ApiModelProperty(value = "是否必填,0-不是, 1-是", example = "1")
    @TableField("is_necessary")
    private Integer isNecessary;


    public Integer getId() {
        return id;
    }

    public SkuGoodSpecValue setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSpecValue() {
        return specValue;
    }

    public SkuGoodSpecValue setSpecValue(String specValue) {
        this.specValue = specValue;
        return this;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public SkuGoodSpecValue setSkuId(Integer skuId) {
        this.skuId = skuId;
        return this;
    }

    public Integer getSpecItemId() {
        return specItemId;
    }

    public SkuGoodSpecValue setSpecItemId(Integer specItemId) {
        this.specItemId = specItemId;
        return this;
    }

    public String getSpecItemName() {
        return specItemName;
    }

    public SkuGoodSpecValue setSpecItemName(String specItemName) {
        this.specItemName = specItemName;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public SkuGoodSpecValue setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public SkuGoodSpecValue setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getSpecType() {
        return specType;
    }

    public SkuGoodSpecValue setSpecType(String specType) {
        this.specType = specType;
        return this;
    }

    public String getEnumOptions() {
        return enumOptions;
    }

    public SkuGoodSpecValue setEnumOptions(String enumOptions) {
        this.enumOptions = enumOptions;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public SkuGoodSpecValue setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public Integer getIsNecessary() {
        return isNecessary;
    }

    public SkuGoodSpecValue setIsNecessary(Integer isNecessary) {
        this.isNecessary = isNecessary;
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
                ", isNecessary=" + isNecessary +
                "}";
    }
}
