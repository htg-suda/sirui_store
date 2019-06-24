package com.htg.common.vo.seller.shop;

import io.swagger.annotations.ApiModelProperty;

public class ShopSellerBankInfoVo {

    @ApiModelProperty(value = "法人姓名", example = "招财猫")
    private String legalPersonName;

    @ApiModelProperty(value = "法人身份证号码", example = "346767655434521678")
    private String legalPersonIdentityNum;


    @ApiModelProperty(value = "法人身份证的正面照片", example = "xxxx.png")
    private String legalPersonIdentityFrontUrl;


    @ApiModelProperty(value = "法人身份证的正面照片", example = "xxxx.png")
    private String legalPersonIdentityBackUrl;


    @ApiModelProperty(value = "账户开户人姓名", example = "招财猫")
    private String bankAccountName;
    /**
     * 开户银行
     */
    @ApiModelProperty(value = "开户银行", example = "上海银行")
    private String bankName;


    @ApiModelProperty(value = "开户银行卡号", example = "54356234623446234")
    private String bankAccountCardNum;


    @ApiModelProperty(value = "开户许可证编码", example = "记记记哦积极哦i机")
    private String bankAccountPermitNum;


    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLegalPersonIdentityNum() {
        return legalPersonIdentityNum;
    }

    public void setLegalPersonIdentityNum(String legalPersonIdentityNum) {
        this.legalPersonIdentityNum = legalPersonIdentityNum;
    }

    public String getLegalPersonIdentityFrontUrl() {
        return legalPersonIdentityFrontUrl;
    }

    public void setLegalPersonIdentityFrontUrl(String legalPersonIdentityFrontUrl) {
        this.legalPersonIdentityFrontUrl = legalPersonIdentityFrontUrl;
    }

    public String getLegalPersonIdentityBackUrl() {
        return legalPersonIdentityBackUrl;
    }

    public void setLegalPersonIdentityBackUrl(String legalPersonIdentityBackUrl) {
        this.legalPersonIdentityBackUrl = legalPersonIdentityBackUrl;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountCardNum() {
        return bankAccountCardNum;
    }

    public void setBankAccountCardNum(String bankAccountCardNum) {
        this.bankAccountCardNum = bankAccountCardNum;
    }

    public String getBankAccountPermitNum() {
        return bankAccountPermitNum;
    }

    public void setBankAccountPermitNum(String bankAccountPermitNum) {
        this.bankAccountPermitNum = bankAccountPermitNum;
    }
}
