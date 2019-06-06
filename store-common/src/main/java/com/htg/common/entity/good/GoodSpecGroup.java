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

/**
 * <p>
 * 规格组表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@ApiModel
@TableName("tb_good_spec_group")
public class GoodSpecGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "规格主键", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @NotBlank(message = "规格组名不能为空")
    @ApiModelProperty(value = "规格组名", example = "位置", dataType = "String", required = true)
    @TableField("name")
    private String name;


    @NotBlank(message = "商品分类id不能为空")
    @ApiModelProperty(value = "商品分类id", example = "5", dataType = "int", required = true)
    @TableField("category_id")
    private Integer categoryId;


    @JsonIgnore
    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public GoodSpecGroup setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodSpecGroup setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public GoodSpecGroup setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public GoodSpecGroup setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "GoodSpecGroup{" +
                "id=" + id +
                ", name=" + name +
                ", categoryId=" + categoryId +
                ", delFlag=" + delFlag +
                "}";
    }
}
