package com.htg.common.entity.seller;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 银行信息表
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
@TableName("sr_seller_bank_info")
public class SellerBankInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 商户编号,uuid ,参考商户表
     */
    @ApiModelProperty(value ="商户编号,uuid ,参考商户表",example = "uuid",hidden = true)
    @TableId("seller_sn")
    private String sellerSn;



    @ApiModelProperty(value = "法人姓名",example = "招财猫")
    @TableField("legal_person_name")
    private String legalPersonName;


    @ApiModelProperty(value = "法人身份证号码",example = "346767655434521678")
    @TableField("legal_person_identity_num")
    private String legalPersonIdentityNum;



    @ApiModelProperty(value = "法人身份证的正面照片",example = "xxxx.png")
    @TableField("legal_person_identity_front_url")
    private String legalPersonIdentityFrontUrl;



    @ApiModelProperty(value = "法人身份证的正面照片",example = "xxxx.png")
    @TableField("legal_person_identity_back_url")
    private String legalPersonIdentityBackUrl;


    @NotBlank(message = "账户开户人姓名不能为空")
    @ApiModelProperty(value = "账户开户人姓名",example = "招财猫")
    @TableField("bank_account_name")
    private String bankAccountName;
    /**
     * 开户银行
     */
    @NotBlank(message = "开户银行不能为空")
    @ApiModelProperty(value = "开户银行",example = "上海银行")
    @TableField("bank_name")
    private String bankName;


    @NotBlank(message = "开户银行卡号不能为空")
    @ApiModelProperty(value = "开户银行卡号",example = "54356234623446234")
    @TableField("bank_account_card_num")
    private String bankAccountCardNum;



    @ApiModelProperty(value = "开户许可证编码",example = "记记记哦积极哦i机")
    @TableField("bank_account_permit_num")
    private String bankAccountPermitNum;



    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除",example = "0",hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public String getSellerSn() {
        return sellerSn;
    }

    public SellerBankInfo setSellerSn(String sellerSn) {
        this.sellerSn = sellerSn;
        return this;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public SellerBankInfo setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
        return this;
    }

    public String getLegalPersonIdentityNum() {
        return legalPersonIdentityNum;
    }

    public SellerBankInfo setLegalPersonIdentityNum(String legalPersonIdentityNum) {
        this.legalPersonIdentityNum = legalPersonIdentityNum;
        return this;
    }

    public String getLegalPersonIdentityFrontUrl() {
        return legalPersonIdentityFrontUrl;
    }

    public SellerBankInfo setLegalPersonIdentityFrontUrl(String legalPersonIdentityFrontUrl) {
        this.legalPersonIdentityFrontUrl = legalPersonIdentityFrontUrl;
        return this;
    }

    public String getLegalPersonIdentityBackUrl() {
        return legalPersonIdentityBackUrl;
    }

    public SellerBankInfo setLegalPersonIdentityBackUrl(String legalPersonIdentityBackUrl) {
        this.legalPersonIdentityBackUrl = legalPersonIdentityBackUrl;
        return this;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public SellerBankInfo setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public SellerBankInfo setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getBankAccountCardNum() {
        return bankAccountCardNum;
    }

    public SellerBankInfo setBankAccountCardNum(String bankAccountCardNum) {
        this.bankAccountCardNum = bankAccountCardNum;
        return this;
    }

    public String getBankAccountPermitNum() {
        return bankAccountPermitNum;
    }

    public SellerBankInfo setBankAccountPermitNum(String bankAccountPermitNum) {
        this.bankAccountPermitNum = bankAccountPermitNum;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public SellerBankInfo setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "SellerBankInfo{" +
        "sellerSn=" + sellerSn +
        ", legalPersonName=" + legalPersonName +
        ", legalPersonIdentityNum=" + legalPersonIdentityNum +
        ", legalPersonIdentityFrontUrl=" + legalPersonIdentityFrontUrl +
        ", legalPersonIdentityBackUrl=" + legalPersonIdentityBackUrl +
        ", bankAccountName=" + bankAccountName +
        ", bankName=" + bankName +
        ", bankAccountCardNum=" + bankAccountCardNum +
        ", bankAccountPermitNum=" + bankAccountPermitNum +
        ", delFlag=" + delFlag +
        "}";
    }
}
