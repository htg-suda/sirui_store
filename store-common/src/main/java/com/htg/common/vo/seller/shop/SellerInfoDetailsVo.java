package com.htg.common.vo.seller.shop;

import io.swagger.annotations.ApiModelProperty;

public class SellerInfoDetailsVo {
    @ApiModelProperty(value = "商户基本信息")
    private ShopSellerInfoVo sellerInfoVo;

    @ApiModelProperty(value = "商户企业信息")
    private ShopSellerEnterpriseInfoVo enterpriseInfoVo;


    @ApiModelProperty(value = "商户银行信息")
    private ShopSellerBankInfoVo sellerBankInfoVo;


    public ShopSellerInfoVo getSellerInfoVo() {
        return sellerInfoVo;
    }

    public void setSellerInfoVo(ShopSellerInfoVo sellerInfoVo) {
        this.sellerInfoVo = sellerInfoVo;
    }

    public ShopSellerEnterpriseInfoVo getEnterpriseInfoVo() {
        return enterpriseInfoVo;
    }

    public void setEnterpriseInfoVo(ShopSellerEnterpriseInfoVo enterpriseInfoVo) {
        this.enterpriseInfoVo = enterpriseInfoVo;
    }

    public ShopSellerBankInfoVo getSellerBankInfoVo() {
        return sellerBankInfoVo;
    }

    public void setSellerBankInfoVo(ShopSellerBankInfoVo sellerBankInfoVo) {
        this.sellerBankInfoVo = sellerBankInfoVo;
    }
}