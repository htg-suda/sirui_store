package com.htg.common.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>
 * 商品分类表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
/*
 *
 * */

// https://www.jianshu.com/p/764eaf6c0afe
@ApiModel("商品分类")
public class GoodCategoryVo extends BaseEntity {


    @ApiModelProperty(value = "商品分类id",example = "0", name = "id", dataType = "int", required = true)
    private Integer id;

    @ApiModelProperty(value = "父级别的类id, id为0的时候是根分类", example = "0", name = "parentId", dataType = "int", required = true)
    private Integer parentId;

    @ApiModelProperty(value = "分类名", example = "虚拟商品", name = "name", dataType = "String", required = true)
    private String name;

    @ApiModelProperty(value = "分类图标url", example = "xxxx.png", name = "icon", dataType = "String", required = true)
    private String icon;

    //@Size(max = 100, message ="排序字 0~100") size是用于集合校验的
    @ApiModelProperty(value = "分类排序字段 0~100,越小越靠前", example = "10", name = "sort", dataType = "int", required = true)
    private Integer sort;

    @ApiModelProperty(value = "佣金比例%", example = "0.5", name = "commissionRate", dataType = "String", required = true)
    private BigDecimal commissionRate;


    public Integer getId() {
        return id;
    }

    public GoodCategoryVo setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public GoodCategoryVo setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodCategoryVo setName(String name) {
        this.name = name;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public GoodCategoryVo setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public GoodCategoryVo setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public GoodCategoryVo setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
        return this;
    }


}
