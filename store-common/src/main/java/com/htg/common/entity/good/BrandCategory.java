package com.htg.common.entity.good;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 品牌和分类的关系表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@TableName("sr_brand_category")
public class BrandCategory extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 品牌表id
     */
    @ApiModelProperty(value = "品牌分类关系id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @NotNull(message = "分类id 不能为空")
    @ApiModelProperty(value = "分类id", example = "10", name = "categoryId", dataType = "int", required = true)
    @TableField("category_id")
    private Integer categoryId;


    @NotNull(message = "品牌id 不能为空")
    @ApiModelProperty(value = "品牌id", example = "10", name = "brandId", dataType = "int", required = true)
    @TableField("brand_id")
    private Integer brandId;


    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public BrandCategory setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public BrandCategory setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public BrandCategory setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public BrandCategory setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "BrandCategory{" +
        "id=" + id +
        ", categoryId=" + categoryId +
        ", brandId=" + brandId +
        ", delFlag=" + delFlag +
        "}";
    }
}
