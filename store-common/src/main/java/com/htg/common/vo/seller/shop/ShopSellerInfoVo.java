package com.htg.common.vo.seller.shop;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class ShopSellerInfoVo {

    @ApiModelProperty(value = "商户logo",example = "xxxx.png")
    private String logo;


    @ApiModelProperty(value = " 0-待审核,1-审核通过已激活,-1 申请未通过 ,10-商户冻结",example = "1",hidden = true)
    private Integer state;


    @ApiModelProperty(value = "冻结原因或申请未通过原因",example = "logo 太难看了啊")
    private String stateRemark;

    @ApiModelProperty(value = "商户类型,0-企业商户 1-个人商户",example = "0")
    private Integer type;


    @ApiModelProperty(value = "管理员的姓名,必须是身份证上的姓名",example = "招財貓")
    private String adminName;


    @ApiModelProperty(value = "管理员的身份证号码,如果是个人商户就是个人的身份证号码",example = "32092519987876541X")
    private String adminIdentityNum;


    @ApiModelProperty(value = "企业管理员或个人商户的手机号码",example = "18717919375")
    private String adminMobPhone;


    @ApiModelProperty(value = "经营范围 以逗号隔开",example = "教育,文化,娱乐")
    private String businessRange;
    /**
     * 企业管理员或个人商户的身份证的正面照片
     */
    @ApiModelProperty(value = "企业管理员或个人商户的身份证的正面照片",example = "xxx.png")
    private String adminIdentityFrontUrl;


    @NotBlank(message = "业管理员或个人商户的身份证的背面照片不能为空")
    private String adminIdentityBackUrl;

    @ApiModelProperty(value = "客服id,参考客服表",example = "0")
    private Integer cusServiceId;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateRemark() {
        return stateRemark;
    }

    public void setStateRemark(String stateRemark) {
        this.stateRemark = stateRemark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}
