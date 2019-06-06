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

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@ApiModel
@TableName("sr_brand")
public class Brand extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌表id
     */
    @ApiModelProperty(value = "品牌id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @NotBlank(message = "中文名不能为空")
    @ApiModelProperty(value = "品牌中文名", example = "邦德乐思", name = "name_cn", dataType = "String", required = true)
    @TableField("name_cn")
    private String nameCn;


    @NotBlank(message = "英文名不能为空")
    @ApiModelProperty(value = "品牌英文名", example = "bdls", name = "name_eg", dataType = "String", required = true)
    @TableField("name_eg")
    private String nameEg;


    @NotBlank(message = "图标不能为空")
    @ApiModelProperty(value = "品牌logo url", example = "xxxx.png", name = "icon", dataType = "String", required = true)
    @TableField("icon")
    private String icon;


    @NotBlank(message = "品牌首字母不能为空")
    @Length(max = 1, min = 1, message = "首字母只能有1个字符")
    @ApiModelProperty(value = "品牌首字母,必须大写", example = "A", name = "initial", dataType = "String", required = true)
    @TableField("initial")
    private String initial;






    @NotNull(message = "排序字段不可为空")
    @Min(value = 0, message = "排序字0~100")
    @Max(value = 100, message = "排序字0~100")
    @ApiModelProperty(value = "品牌排序字段 0~100,越小越靠前", example = "10", name = "sort", dataType = "int", required = true)
    @TableField("sort")
    private Integer sort;

    @NotNull(message = "品牌归属不能为空")
    @ApiModelProperty(value = "品牌归属 0-商家, 1-平台", example = "0", required = true)
    @TableField("ascription")
    private Integer ascription;

    @ApiModelProperty(value = "品牌审核 1-通过，0-未通过，10-审核中", example = "10", name = "sort", dataType = "String", hidden = true, required = false)
    @TableField("verify")
    private Integer verify;


    @ApiModelProperty(value = "审核不通过的原因", example = "10", name = "sort", dataType = "String", hidden = true, required = false)
    @TableField("verify_remark")
    private String verifyRemark;


    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", example = "10", name = "sort", dataType = "int", hidden = true, required = false)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public Brand setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNameCn() {
        return nameCn;
    }

    public Brand setNameCn(String nameCn) {
        this.nameCn = nameCn;
        return this;
    }

    public String getNameEg() {
        return nameEg;
    }

    public Brand setNameEg(String nameEg) {
        this.nameEg = nameEg;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Brand setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getInitial() {
        return initial;
    }

    public Brand setInitial(String initial) {
        this.initial = initial;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public Brand setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getVerify() {
        return verify;
    }

    public Brand setVerify(Integer verify) {
        this.verify = verify;
        return this;
    }

    public String getVerifyRemark() {
        return verifyRemark;
    }

    public Brand setVerifyRemark(String verifyRemark) {
        this.verifyRemark = verifyRemark;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Brand setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Integer getAscription() {
        return ascription;
    }

    public void setAscription(Integer ascription) {
        this.ascription = ascription;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", nameCn='" + nameCn + '\'' +
                ", nameEg='" + nameEg + '\'' +
                ", icon='" + icon + '\'' +
                ", initial='" + initial + '\'' +
                ", ascription=" + ascription +
                ", sort=" + sort +
                ", verify=" + verify +
                ", verifyRemark='" + verifyRemark + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
