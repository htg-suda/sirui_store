package com.htg.common.entity.good;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
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
@TableName("sr_good_category")
public class GoodCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 商品分类id
     */
    @ApiModelProperty(hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "父分类不能为空")
    @ApiModelProperty(value = "父级别的类id, id为0的时候是根分类", example = "0", name = "parentId", dataType = "int", required = true)
    @TableField("parent_id")
    private Integer parentId;

    @Length(min = 2, max = 10, message = "分类名必须在2~10字符之间")
    @ApiModelProperty(value = "分类名", example = "虚拟商品", name = "name", dataType = "String", required = true)
    @TableField("name")
    private String name;

    @NotNull(message = "图标不可为空")
    @ApiModelProperty(value = "分类图标url", example = "xxxx.png", name = "icon", dataType = "String", required = true)
    @TableField("icon")
    private String icon;

    //@Size(max = 100, message ="排序字 0~100") size是用于集合校验的
    @NotNull(message = "排序字段不可为空")
    @Min(value = 0, message = "排序字0~100")
    @Max(value = 100, message = "排序字0~100")
    @ApiModelProperty(value = "分类排序字段 0~100,越小越靠前", example = "10", name = "sort", dataType = "int", required = true)
    @TableField("sort")
    private Integer sort;

    @Max(value = 100,message = "佣金比例最大不能大于100%")
    @Digits(integer = 3, fraction = 2, message = "佣金比例,需要保留两位有效数字")
    @ApiModelProperty(value = "佣金比例%", example = "0.5", name = "commissionRate", dataType = "String", required = true)
    @TableField("commission_rate")
    private BigDecimal commissionRate;


    /**
     * 删除状态,0-有效,-1 -删除
     */
    @ApiModelProperty(hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public GoodCategory setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public GoodCategory setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodCategory setName(String name) {
        this.name = name;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public GoodCategory setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public GoodCategory setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public GoodCategory setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public GoodCategory setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "GoodCategoryVo{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name=" + name +
                ", icon=" + icon +
                ", sort=" + sort +
                ", commissionRate=" + commissionRate +
                ", delFlag=" + delFlag +
                "}";
    }
}
