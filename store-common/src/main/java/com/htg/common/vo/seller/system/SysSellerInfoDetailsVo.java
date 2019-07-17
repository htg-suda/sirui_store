package com.htg.common.vo.seller.system;

import com.htg.common.vo.seller.shop.ShopSellerBankInfoVo;
import com.htg.common.vo.seller.shop.ShopSellerEnterpriseInfoVo;
import com.htg.common.vo.seller.shop.ShopSellerInfoVo;
import io.swagger.annotations.ApiModelProperty;

public class SysSellerInfoDetailsVo {
    @ApiModelProperty(value = "商户基本信息")
    private ShopSellerInfoVo sellerInfoVo;

    @ApiModelProperty(value = "商户企业信息")
    private ShopSellerEnterpriseInfoVo enterpriseInfoVo;


    @ApiModelProperty(value = "商户银行信息")
    private ShopSellerBankInfoVo sellerBankInfoVo;

    @ApiModelProperty(value = "用户基本信息")
    private SrUserVo srUserVo;

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

    public SrUserVo getSrUserVo() {
        return srUserVo;
    }

    public void setSrUserVo(SrUserVo srUserVo) {
        this.srUserVo = srUserVo;
    }
}