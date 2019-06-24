package com.htg.common.vo.seller.shop;

import io.swagger.annotations.ApiModelProperty;

public class ShopSellerEnterpriseInfoVo {
    @ApiModelProperty(value = "企业名,必须是营业执照上的", example = "邦德乐思")
    private String enterpriseName;


    @ApiModelProperty(value = "15位企业税号", example = "XXXXXXXXXXXXXXX")
    private String taxSn;


    @ApiModelProperty(value = "15位营业执照注册号", example = "XXXXXXXXXXXXXXX")
    private String businessLicNum;


    @ApiModelProperty(value = "省ID", example = "1001")
    private Integer province;



    @ApiModelProperty(value = "市ID", example = "1003")
    private Integer city;


    @ApiModelProperty(value = "县/区ID", example = "1004")
    private Integer county;



    @ApiModelProperty(value = "详细地址", example = "唐宁街10号")
    private String addressDetail;


    @ApiModelProperty(value = "企业座机号码", example = "0515-86561763")
    private String telPhone;



    @ApiModelProperty(value = "企业营业执照图片地址", example = "xxxxxx.png")
    private String bussinessLicImgUrl;


    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getTaxSn() {
        return taxSn;
    }

    public void setTaxSn(String taxSn) {
        this.taxSn = taxSn;
    }

    public String getBusinessLicNum() {
        return businessLicNum;
    }

    public void setBusinessLicNum(String businessLicNum) {
        this.businessLicNum = businessLicNum;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getBussinessLicImgUrl() {
        return bussinessLicImgUrl;
    }

    public void setBussinessLicImgUrl(String bussinessLicImgUrl) {
        this.bussinessLicImgUrl = bussinessLicImgUrl;
    }
}
