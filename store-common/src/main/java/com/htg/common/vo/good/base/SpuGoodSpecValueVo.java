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
 * 商品spu规格值表
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */

@TableName("sr_spu_good_spec_value")
public class SpuGoodSpecValueVo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 通用的规格参数值的id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 规格参数值,当参数名规定了 numeric 的时候表示是可以转换为数值类型
     */
    @NotBlank(message = "参数值不能为空")
    @ApiModelProperty(value = "规格参数值", example = "工位", required = true)
    @TableField("spec_value")
    private String specValue;

    @NotNull(message = "spu_id 不能为空")
    @ApiModelProperty(value = "商品spu_id", example = "5", required = true)
    @TableField("spu_id")
    private Integer spuId;


    @NotNull(message = "规格参数名id 不能为空")
    @ApiModelProperty(value = "规格参数名id", example = "1", required = true)
    @TableField("spec_item_id")
    private Integer specItemId;


    @NotBlank(message = "规格参数健值名 不能为空")
    @ApiModelProperty(value = "规格参数健值名", example = "位置类型", required = true)
    @TableField("spec_item_name")
    private String specItemName;


    @NotNull(message = "分类id 不能为空")
    @ApiModelProperty(value = "分类id", example = "4", required = true)
    @TableField("category_id")
    private Integer categoryId;


    @NotNull(message = "规格组id 不能为空")
    @ApiModelProperty(value = "规格组id", example = "4", required = true)
    @TableField("group_id")
    private Integer groupId;


    @NotBlank(message = "规格值的类型 不能为空")
    @ApiModelProperty(value = "规格值的类型, num-数值类型 , enum 枚举类型 ,str-文本类型,images-图片url地址如xxx.png;xxx.png", example = "4", required = true)
    @TableField("spec_type")
    private String specType;


    @ApiModelProperty(value = "如果是枚举类型的话,其各个枚举值,以逗号分割", example = "工位;会议室")
    @TableField("enum_options")
    private String enumOptions;


    @ApiModelProperty(value = "在为数值类型的时候的单位,比如12mm中的mm", example = "mm")
    @TableField("unit")
    private String unit;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getSpecItemId() {
        return specItemId;
    }

    public void setSpecItemId(Integer specItemId) {
        this.specItemId = specItemId;
    }

    public String getSpecItemName() {
        return specItemName;
    }

    public void setSpecItemName(String specItemName) {
        this.specItemName = specItemName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getSpecType() {
        return specType;
    }

    public void setSpecType(String specType) {
        this.specType = specType;
    }

    public String getEnumOptions() {
        return enumOptions;
    }

    public void setEnumOptions(String enumOptions) {
        this.enumOptions = enumOptions;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "SpuGoodSpecValueVo{" +
                "id=" + id +
                ", specValue='" + specValue + '\'' +
                ", spuId=" + spuId +
                ", specItemId=" + specItemId +
                ", specItemName='" + specItemName + '\'' +
                ", categoryId=" + categoryId +
                ", groupId=" + groupId +
                ", specType='" + specType + '\'' +
                ", enumOptions='" + enumOptions + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
