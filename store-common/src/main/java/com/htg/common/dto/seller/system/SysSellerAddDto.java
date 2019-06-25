package com.htg.common.dto.seller.system;
import com.htg.common.dto.seller.user.SrUserDto;
import com.htg.common.entity.seller.SellerBankInfo;
import com.htg.common.entity.seller.SellerEnterpriseInfo;
import com.htg.common.entity.seller.SellerInfo;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SysSellerAddDto {
    @NotNull(message = "商户基本信息不能为空")
    @Valid
    private SellerInfo sellerInfo;

    @Valid
    private SellerEnterpriseInfo enterpriseInfo;


    @Valid
    @NotNull(message = "商户银行信息不能为空")
    private SellerBankInfo sellerBankInfo;

    @Valid
    @NotNull(message = "用户信息不能为空")
    private SrUserDto srUserDto;


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

    public SrUserDto getSrUserDto() {
        return srUserDto;
    }

    public void setSrUserDto(SrUserDto srUserDto) {
        this.srUserDto = srUserDto;
    }

    @Override
    public String toString() {
        return "SysSellerAddDto{" +
                "sellerInfo=" + sellerInfo +
                ", enterpriseInfo=" + enterpriseInfo +
                ", sellerBankInfo=" + sellerBankInfo +
                ", srUserDto=" + srUserDto +
                '}';
    }
}
