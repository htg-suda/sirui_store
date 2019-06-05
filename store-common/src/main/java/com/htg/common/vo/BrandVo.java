package com.htg.common.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@ApiModel
public class BrandVo extends BaseEntity {
    @ApiModelProperty(value = "品牌id", example = "1", name = "id", dataType = "int", required = true)
    private Integer id;


    @ApiModelProperty(value = "品牌中文名", example = "邦德乐思", name = "name_cn", dataType = "String", required = true)
    private String nameCn;


    @ApiModelProperty(value = "品牌英文名", example = "bdls", name = "name_eg", dataType = "String", required = true)
    private String nameEg;


    @ApiModelProperty(value = "品牌logo url", example = "xxxx.png", name = "icon", dataType = "String", required = true)
    private String icon;


    @ApiModelProperty(value = "品牌归属 0-商家, 1-平台", example = "0", required = true)
    private Integer ascription;


    @ApiModelProperty(value = "品牌首字母,必须大写", example = "A", name = "initial", dataType = "String", required = true)
    private String initial;


    @ApiModelProperty(value = "品牌排序字段 0~100,越小越靠前", example = "10", name = "sort", dataType = "int", required = true)
    private Integer sort;


    @ApiModelProperty(value = "品牌审核 1-通过，0-未通过，10-审核中", example = "10", name = "sort", dataType = "String", hidden = true, required = false)
    private Integer verify;


    @ApiModelProperty(value = "审核不通过的原因", example = "10", name = "sort", dataType = "String", hidden = true, required = false)
    private String verifyRemark;





    public Integer getId() {
        return id;
    }

    public BrandVo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNameCn() {
        return nameCn;
    }

    public BrandVo setNameCn(String nameCn) {
        this.nameCn = nameCn;
        return this;
    }

    public String getNameEg() {
        return nameEg;
    }

    public BrandVo setNameEg(String nameEg) {
        this.nameEg = nameEg;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public BrandVo setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getInitial() {
        return initial;
    }

    public BrandVo setInitial(String initial) {
        this.initial = initial;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public BrandVo setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getVerify() {
        return verify;
    }

    public BrandVo setVerify(Integer verify) {
        this.verify = verify;
        return this;
    }

    public String getVerifyRemark() {
        return verifyRemark;
    }

    public BrandVo setVerifyRemark(String verifyRemark) {
        this.verifyRemark = verifyRemark;
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
        return "BrandVo{" +
                "id=" + id +
                ", nameCn='" + nameCn + '\'' +
                ", nameEg='" + nameEg + '\'' +
                ", icon='" + icon + '\'' +
                ", ascription=" + ascription +
                ", initial='" + initial + '\'' +
                ", sort=" + sort +
                ", verify=" + verify +
                ", verifyRemark='" + verifyRemark + '\'' +
                '}';
    }
}
