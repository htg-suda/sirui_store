package com.htg.common.dto.seller.system;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SellerModifyInfo {

    @NotNull(message = "商户id不能为空")
    @ApiModelProperty(value = "id",example = "1")
    private Integer id;

    /**
     * 用户id,参考用户表
     */

    @NotBlank(message = "商户logo不能为空")
    @ApiModelProperty(value = "商户logo",example = "xxxx.png")
    private String logo;


    @NotNull(message = "管理员姓名不能为空")
    @ApiModelProperty(value = "管理员的姓名,必须是身份证上的姓名",example = "招財貓")
    private String adminName;


    @NotBlank(message = "身份证不能为空")
    @ApiModelProperty(value = "管理员的身份证号码,如果是个人商户就是个人的身份证号码",example = "32092519987876541X")
    private String adminIdentityNum;


    @NotBlank(message = "商户管理员手机号码不能为空")
    @ApiModelProperty(value = "企业管理员或个人商户的手机号码",example = "18717919375")
    private String adminMobPhone;


    @NotBlank(message = "经营范围不能为空")
    @ApiModelProperty(value = "经营范围 以逗号隔开",example = "教育,文化,娱乐")
    private String businessRange;
    /**
     * 企业管理员或个人商户的身份证的正面照片
     */
    @NotBlank(message = "企业管理员或个人商户的身份证的正面照片不能为空")
    @ApiModelProperty(value = "企业管理员或个人商户的身份证的正面照片",example = "xxx.png")
    private String adminIdentityFrontUrl;


    @NotBlank(message = "业管理员或个人商户的身份证的背面照片不能为空")
    @ApiModelProperty(value = "企业管理员或个人商户的身份证的背面照片",example = "xxx.png")
    private String adminIdentityBackUrl;



    @NotNull(message = "客服id不能为空")
    @ApiModelProperty(value = "客服id,参考客服表",example = "0")
    private Integer cusServiceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminIdentityNum() {
        return adminIdentityNum;
    }

    public void setAdminIdentityNum(String adminIdentityNum) {
        this.adminIdentityNum = adminIdentityNum;
    }

    public String getAdminMobPhone() {
        return adminMobPhone;
    }

    public void setAdminMobPhone(String adminMobPhone) {
        this.adminMobPhone = adminMobPhone;
    }

    public String getBusinessRange() {
        return businessRange;
    }

    public void setBusinessRange(String businessRange) {
        this.businessRange = businessRange;
    }

    public String getAdminIdentityFrontUrl() {
        return adminIdentityFrontUrl;
    }

    public void setAdminIdentityFrontUrl(String adminIdentityFrontUrl) {
        this.adminIdentityFrontUrl = adminIdentityFrontUrl;
    }

    public String getAdminIdentityBackUrl() {
        return adminIdentityBackUrl;
    }

    public void setAdminIdentityBackUrl(String adminIdentityBackUrl) {
        this.adminIdentityBackUrl = adminIdentityBackUrl;
    }

    public Integer getCusServiceId() {
        return cusServiceId;
    }

    public void setCusServiceId(Integer cusServiceId) {
        this.cusServiceId = cusServiceId;
    }

    @Override
    public String toString() {
        return "SellerModifyInfo{" +
                "id=" + id +
                ", logo='" + logo + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminIdentityNum='" + adminIdentityNum + '\'' +
                ", adminMobPhone='" + adminMobPhone + '\'' +
                ", businessRange='" + businessRange + '\'' +
                ", adminIdentityFrontUrl='" + adminIdentityFrontUrl + '\'' +
                ", adminIdentityBackUrl='" + adminIdentityBackUrl + '\'' +
                ", cusServiceId=" + cusServiceId +
                '}';
    }
}
