package com.htg.common.dto.seller.system;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SysSellerModifyDto {
    @NotNull(message = "商户基本信息不能为空")
    @Valid
    private SellerModifyInfo sellerModifyInfo;

    @Valid
    private SellerEnterpriseModifyInfo enterpriseModifyInfo;

    @Valid
    @NotNull(message = "商户银行信息不能为空")
    private SellerBankModifyInfo sellerBankModifyInfo;

    public SellerModifyInfo getSellerModifyInfo() {
        return sellerModifyInfo;
    }

    public void setSellerModifyInfo(SellerModifyInfo sellerModifyInfo) {
        this.sellerModifyInfo = sellerModifyInfo;
    }

    public SellerEnterpriseModifyInfo getEnterpriseModifyInfo() {
        return enterpriseModifyInfo;
    }

    public void setEnterpriseModifyInfo(SellerEnterpriseModifyInfo enterpriseModifyInfo) {
        this.enterpriseModifyInfo = enterpriseModifyInfo;
    }

    public SellerBankModifyInfo getSellerBankModifyInfo() {
        return sellerBankModifyInfo;
    }

    public void setSellerBankModifyInfo(SellerBankModifyInfo sellerBankModifyInfo) {
        this.sellerBankModifyInfo = sellerBankModifyInfo;
    }

    @Override
    public String toString() {
        return "SysSellerModifyDto{" +
                "sellerModifyInfo=" + sellerModifyInfo +
                ", enterpriseModifyInfo=" + enterpriseModifyInfo +
                ", sellerBankModifyInfo=" + sellerBankModifyInfo +
                '}';
    }
}
