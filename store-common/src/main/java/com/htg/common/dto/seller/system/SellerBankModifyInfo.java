package com.htg.common.dto.seller.system;

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
public class SellerBankModifyInfo extends BaseEntity {

    @NotBlank(message = "法人姓名,对于企业商户必须要有法人")
    @ApiModelProperty(value = "法人姓名", example = "招财猫")
    private String legalPersonName;

    @NotBlank(message = "对于企业商户必须要有法人")
    @ApiModelProperty(value = "法人身份证号码", example = "346767655434521678")
    private String legalPersonIdentityNum;


    @NotBlank(message = "法人身份证的正面照片不能为空")
    @ApiModelProperty(value = "法人身份证的正面照片", example = "xxxx.png")
    private String legalPersonIdentityFrontUrl;


    @NotBlank(message = "法人身份证的背面照片不能为空")
    @ApiModelProperty(value = "法人身份证的正面照片", example = "xxxx.png")
    private String legalPersonIdentityBackUrl;


    @NotBlank(message = "账户开户人姓名不能为空")
    @ApiModelProperty(value = "账户开户人姓名", example = "招财猫")
    private String bankAccountName;
    /**
     * 开户银行
     */
    @NotBlank(message = "开户银行不能为空")
    @ApiModelProperty(value = "开户银行", example = "上海银行")
    private String bankName;


    @NotBlank(message = "开户银行卡号不能为空")
    @ApiModelProperty(value = "开户银行卡号", example = "54356234623446234")
    private String bankAccountCardNum;


    @NotBlank(message = "开户许可证编码,对于企业商户必须要有")
    @ApiModelProperty(value = "开户许可证编码", example = "记记记哦积极哦i机")
    private String bankAccountPermitNum;


    public String getLegalPersonName() {
        return legalPersonName;
    }

    public SellerBankModifyInfo setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
        return this;
    }

    public String getLegalPersonIdentityNum() {
        return legalPersonIdentityNum;
    }

    public SellerBankModifyInfo setLegalPersonIdentityNum(String legalPersonIdentityNum) {
        this.legalPersonIdentityNum = legalPersonIdentityNum;
        return this;
    }

    public String getLegalPersonIdentityFrontUrl() {
        return legalPersonIdentityFrontUrl;
    }

    public SellerBankModifyInfo setLegalPersonIdentityFrontUrl(String legalPersonIdentityFrontUrl) {
        this.legalPersonIdentityFrontUrl = legalPersonIdentityFrontUrl;
        return this;
    }

    public String getLegalPersonIdentityBackUrl() {
        return legalPersonIdentityBackUrl;
    }

    public SellerBankModifyInfo setLegalPersonIdentityBackUrl(String legalPersonIdentityBackUrl) {
        this.legalPersonIdentityBackUrl = legalPersonIdentityBackUrl;
        return this;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public SellerBankModifyInfo setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public SellerBankModifyInfo setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getBankAccountCardNum() {
        return bankAccountCardNum;
    }

    public SellerBankModifyInfo setBankAccountCardNum(String bankAccountCardNum) {
        this.bankAccountCardNum = bankAccountCardNum;
        return this;
    }

    public String getBankAccountPermitNum() {
        return bankAccountPermitNum;
    }

    public SellerBankModifyInfo setBankAccountPermitNum(String bankAccountPermitNum) {
        this.bankAccountPermitNum = bankAccountPermitNum;
        return this;
    }


    @Override
    public String toString() {
        return "SellerBankInfo{" +
                ", legalPersonName=" + legalPersonName +
                ", legalPersonIdentityNum=" + legalPersonIdentityNum +
                ", legalPersonIdentityFrontUrl=" + legalPersonIdentityFrontUrl +
                ", legalPersonIdentityBackUrl=" + legalPersonIdentityBackUrl +
                ", bankAccountName=" + bankAccountName +
                ", bankName=" + bankName +
                ", bankAccountCardNum=" + bankAccountCardNum +
                ", bankAccountPermitNum=" + bankAccountPermitNum +
                "}";
    }
}
