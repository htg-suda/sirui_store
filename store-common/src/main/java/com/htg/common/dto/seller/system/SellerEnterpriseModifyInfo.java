package com.htg.common.dto.seller.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 企业信息表
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */

public class SellerEnterpriseModifyInfo extends BaseEntity {



    @NotBlank(message = "企业名不能为空")
    @ApiModelProperty(value = "企业名,必须是营业执照上的", example = "邦德乐思")
    @TableField("enterprise_name")
    private String enterpriseName;


    @Length(max = 15, min = 15, message = "企业税号必须15位")
    @NotBlank(message = "企业税号不能为空")
    @ApiModelProperty(value = "15位企业税号", example = "XXXXXXXXXXXXXXX")
    @TableField("tax_sn")
    private String taxSn;


    @Length(max = 15, min = 15, message = "营业执照注册号必须15位")
    @NotBlank(message = "营业执照注册号不能为空")
    @ApiModelProperty(value = "15位营业执照注册号", example = "XXXXXXXXXXXXXXX")
    @TableField("business_lic_num")
    private String businessLicNum;


    @NotNull(message = "省ID不能为空")
    @ApiModelProperty(value = "省ID", example = "1001")
    @TableField("province")
    private Integer province;



    @NotNull(message = "市ID不能为空")
    @ApiModelProperty(value = "市ID", example = "1003")
    @TableField("city")
    private Integer city;


    @NotNull(message = "县/区ID不能为空")
    @ApiModelProperty(value = "县/区ID", example = "1004")
    @TableField("county")
    private Integer county;



    @NotBlank(message = "详细地址不能为空")
    @ApiModelProperty(value = "详细地址", example = "唐宁街10号")
    @TableField("address_detail")
    private String addressDetail;


    @NotBlank(message = "企业座机号码不能为空")
    @ApiModelProperty(value = "企业座机号码", example = "0515-86561763")
    @TableField("tel_phone")
    private String telPhone;



    @NotBlank(message = "企业营业执照图片地址不能为空")
    @ApiModelProperty(value = "企业营业执照图片地址", example = "xxxxxx.png")
    @TableField("bussiness_lic_img_url")
    private String bussinessLicImgUrl;




    public String getEnterpriseName() {
        return enterpriseName;
    }

    public SellerEnterpriseModifyInfo setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getTaxSn() {
        return taxSn;
    }

    public SellerEnterpriseModifyInfo setTaxSn(String taxSn) {
        this.taxSn = taxSn;
        return this;
    }

    public String getBusinessLicNum() {
        return businessLicNum;
    }

    public SellerEnterpriseModifyInfo setBusinessLicNum(String businessLicNum) {
        this.businessLicNum = businessLicNum;
        return this;
    }

    public Integer getProvince() {
        return province;
    }

    public SellerEnterpriseModifyInfo setProvince(Integer province) {
        this.province = province;
        return this;
    }

    public Integer getCity() {
        return city;
    }

    public SellerEnterpriseModifyInfo setCity(Integer city) {
        this.city = city;
        return this;
    }

    public Integer getCounty() {
        return county;
    }

    public SellerEnterpriseModifyInfo setCounty(Integer county) {
        this.county = county;
        return this;
    }


    public String getAddressDetail() {
        return addressDetail;
    }

    public SellerEnterpriseModifyInfo setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
        return this;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public SellerEnterpriseModifyInfo setTelPhone(String telPhone) {
        this.telPhone = telPhone;
        return this;
    }

    public String getBussinessLicImgUrl() {
        return bussinessLicImgUrl;
    }

    public SellerEnterpriseModifyInfo setBussinessLicImgUrl(String bussinessLicImgUrl) {
        this.bussinessLicImgUrl = bussinessLicImgUrl;
        return this;
    }



    @Override
    public String toString() {
        return "SellerEnterpriseInfo{" +
                ", enterpriseName=" + enterpriseName +
                ", taxSn=" + taxSn +
                ", businessLicNum=" + businessLicNum +
                ", province=" + province +
                ", city=" + city +
                ", county=" + county +
                ", addressDetail=" + addressDetail +
                ", telPhone=" + telPhone +
                ", bussinessLicImgUrl=" + bussinessLicImgUrl +
                "}";
    }
}
