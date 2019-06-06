package com.htg.common.entity.good;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 规格参数名表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@ApiModel
@TableName("tb_good_spec_item")
public class GoodSpecItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格参数名主键", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "规格参数名不能为空")
    @ApiModelProperty(value = "规格参数名", example = "位置", dataType = "String", required = true)
    @TableField("name")
    private String name;


    @NotNull(message = "产品分类id不能为空")
    @ApiModelProperty(value = "产品分类id", example = "3", dataType = "int", required = true)
    @TableField("category_id")
    private Integer categoryId;


    @NotNull(message = "规格组id不能为空")
    @ApiModelProperty(value = "规格组id", example = "3", dataType = "int", required = true)
    @TableField("group_id")
    private Integer groupId;


    @NotBlank(message = "规格值类型不能为空")
    @ApiModelProperty(value = "规格值的类型, num-数值类型 , str-纯文字类型,images-图片url地址如xxx.png;xxx.png", example = "3", dataType = "String", required = true)
    @TableField("spec_type")
    private String specType;


    @ApiModelProperty(value = "如果是枚举类型的话,其各个枚举值,以逗号分割", example = "工位,学校,办公室", required = true)
    @TableField("enum_options")
    private String enumOptions;

    @ApiModelProperty(value = "在为数值类型的时候的单位,比如12mm中的mm", example = "kg", dataType = "String")
    @TableField("unit")
    private String unit;


    @NotNull(message = "是否为通用属性不能为空")
    @ApiModelProperty(value = "是否属于spu的通用规格属性 0-不是, 1-是", example = "0", dataType = "int", required = true)
    @TableField("is_general")
    private Integer isGeneral;


    @NotNull(message = "是否是必须的规格不能为空")
    @ApiModelProperty(value = "是否是必须的规格,0-不是, 1-是", example = "0", dataType = "int", required = true)
    @TableField("is_necessary")
    private Integer isNecessary;


    @JsonIgnore
    @ApiModelProperty(value = " 删除状态,0-有效,-1 -删除", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public GoodSpecItem setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodSpecItem setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public GoodSpecItem setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GoodSpecItem setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getSpecType() {
        return specType;
    }

    public GoodSpecItem setSpecType(String specType) {
        this.specType = specType;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public GoodSpecItem setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public Integer getIsGeneral() {
        return isGeneral;
    }

    public GoodSpecItem setIsGeneral(Integer isGeneral) {
        this.isGeneral = isGeneral;
        return this;
    }

    public Integer getIsNecessary() {
        return isNecessary;
    }

    public GoodSpecItem setIsNecessary(Integer isNecessary) {
        this.isNecessary = isNecessary;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public GoodSpecItem setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getEnumOptions() {
        return enumOptions;
    }

    public void setEnumOptions(String enumOptions) {
        this.enumOptions = enumOptions;
    }

    @Override
    public String toString() {
        return "GoodSpecItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", groupId=" + groupId +
                ", specType='" + specType + '\'' +
                ", enumOptions='" + enumOptions + '\'' +
                ", unit='" + unit + '\'' +
                ", isGeneral=" + isGeneral +
                ", isNecessary=" + isNecessary +
                ", delFlag=" + delFlag +
                '}';
    }
}
