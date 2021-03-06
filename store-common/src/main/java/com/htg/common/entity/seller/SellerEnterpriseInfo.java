package com.htg.common.entity.seller;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>
 * 企业信息表
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */

@TableName("sr_seller_enterprise_info")
public class SellerEnterpriseInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户编号,uuid ,参考商户表", example = "uuid", hidden = true)
    @TableId("seller_sn")
    private String sellerSn;

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



    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除",example = "0",hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public String getSellerSn() {
        return sellerSn;
    }

    public SellerEnterpriseInfo setSellerSn(String sellerSn) {
        this.sellerSn = sellerSn;
        return this;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public SellerEnterpriseInfo setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public String getTaxSn() {
        return taxSn;
    }

    public SellerEnterpriseInfo setTaxSn(String taxSn) {
        this.taxSn = taxSn;
        return this;
    }

    public String getBusinessLicNum() {
        return businessLicNum;
    }

    public SellerEnterpriseInfo setBusinessLicNum(String businessLicNum) {
        this.businessLicNum = businessLicNum;
        return this;
    }

    public Integer getProvince() {
        return province;
    }

    public SellerEnterpriseInfo setProvince(Integer province) {
        this.province = province;
        return this;
    }

    public Integer getCity() {
        return city;
    }

    public SellerEnterpriseInfo setCity(Integer city) {
        this.city = city;
        return this;
    }

    public Integer getCounty() {
        return county;
    }

    public SellerEnterpriseInfo setCounty(Integer county) {
        this.county = county;
        return this;
    }


    public String getAddressDetail() {
        return addressDetail;
    }

    public SellerEnterpriseInfo setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
        return this;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public SellerEnterpriseInfo setTelPhone(String telPhone) {
        this.telPhone = telPhone;
        return this;
    }

    public String getBussinessLicImgUrl() {
        return bussinessLicImgUrl;
    }

    public SellerEnterpriseInfo setBussinessLicImgUrl(String bussinessLicImgUrl) {
        this.bussinessLicImgUrl = bussinessLicImgUrl;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public SellerEnterpriseInfo setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "SellerEnterpriseInfo{" +
                "sellerSn=" + sellerSn +
                ", enterpriseName=" + enterpriseName +
                ", taxSn=" + taxSn +
                ", businessLicNum=" + businessLicNum +
                ", province=" + province +
                ", city=" + city +
                ", county=" + county +
                ", addressDetail=" + addressDetail +
                ", telPhone=" + telPhone +
                ", bussinessLicImgUrl=" + bussinessLicImgUrl +
                ", delFlag=" + delFlag +
                "}";
    }
}
