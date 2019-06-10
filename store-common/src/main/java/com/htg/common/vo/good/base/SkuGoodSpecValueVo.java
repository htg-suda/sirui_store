package com.htg.common.vo.good.base;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

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

    /**
     * 通用的规格参数值的id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 规格参数值,当参数名规定了 numeric 的时候表示是可以转换为数值类型
     */
    @TableField("spec_value")
    private String specValue;
    /**
     * 商品sku_id
     */
    @TableField("sku_id")
    private Integer skuId;
    /**
     * 规格参数名id
     */
    @TableField("spec_item_id")
    private Integer specItemId;
    /**
     * 规格参数健值
     */
    @TableField("spec_item_name")
    private String specItemName;
    /**
     * 产品分类id
     */
    @TableField("category_id")
    private Integer categoryId;
    /**
     * 规格组id
     */
    @TableField("group_id")
    private Integer groupId;
    /**
     * 规格值的类型, num-数值类型 , enum 枚举类型 ,str-文本类型,images-图片url地址如xxx.png;xxx.png
     */
    @TableField("spec_type")
    private String specType;
    /**
     * 如果是枚举类型的话,其各个枚举值,以逗号分割
     */
    @TableField("enum_options")
    private String enumOptions;
    /**
     * 在为数值类型的时候的单位,比如12mm中的mm
     */
    @TableField("unit")
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
