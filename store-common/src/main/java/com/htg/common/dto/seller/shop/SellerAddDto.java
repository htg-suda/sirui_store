package com.htg.common.dto.seller.shop;

import com.htg.common.entity.seller.SellerBankInfo;
import com.htg.common.entity.seller.SellerEnterpriseInfo;
import com.htg.common.entity.seller.SellerInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class SellerAddDto {

    @NotNull(message = "商户基本信息不能为空")
    @Valid
    private SellerInfo sellerInfo;

    @Valid
    private SellerEnterpriseInfo enterpriseInfo;


    @Valid
    @NotNull(message = "商户银行信息不能为空")
    private SellerBankInfo sellerBankInfo;

    public SellerInfo getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(SellerInfo sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public SellerEnterpriseInfo getEnterpriseInfo() {
        return enterpriseInfo;
    }

    public void setEnterpriseInfo(SellerEnterpriseInfo enterpriseInfo) {
        this.enterpriseInfo = enterpriseInfo;
    }

    public SellerBankInfo getSellerBankInfo() {
        return sellerBankInfo;
    }

    public void setSellerBankInfo(SellerBankInfo sellerBankInfo) {
        this.sellerBankInfo = sellerBankInfo;
    }

    @Override
    public String toString() {
        return "SellerAddDto{" +
                "sellerInfo=" + sellerInfo +
                ", enterpriseInfo=" + enterpriseInfo +
                ", sellerBankInfo=" + sellerBankInfo +
                '}';
    }
}
