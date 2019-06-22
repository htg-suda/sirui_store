package com.htg.common.entity.seller;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 卖家/商户信息表
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
@TableName("sr_seller_info")
public class SellerInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 卖家id
     *
     */
    @ApiModelProperty(value = "id",hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value ="商户编号,uuid ,参考商户表",example = "uuid",hidden = true)
    @TableField("sn")
    private String sn;

    /**
     * 用户id,参考用户表
     */

    @ApiModelProperty(value = "用户id,参考用户表",example = "0",hidden = true)
    @TableField("user_id")
    private Integer userId;

    @NotBlank(message = "商户logo不能为空")
    @ApiModelProperty(value = "商户logo",example = "xxxx.png")
    @TableField("logo")
    private String logo;


    @ApiModelProperty(value = " 0-待审核,1-审核通过已激活,-1 申请未通过 ,10-商户冻结",example = "1",hidden = true)
    @TableField("state")
    private Integer state;


    @ApiModelProperty(value = "冻结原因或申请未通过原因",example = "logo 太难看了啊")
    @TableField("state_remark")
    private String stateRemark;

    @NotNull(message = "商户类型不能为空")
    @ApiModelProperty(value = "商户类型,0-企业商户 1-个人商户",example = "0")
    @TableField("type")
    private Integer type;


    @NotNull(message = "管理员姓名不能为空")
    @ApiModelProperty(value = "管理员的姓名,必须是身份证上的姓名",example = "招財貓")
    @TableField("admin_name")
    private String adminName;


    @NotBlank(message = "身份证不能为空")
    @ApiModelProperty(value = "管理员的身份证号码,如果是个人商户就是个人的身份证号码",example = "32092519987876541X")
    @TableField("admin_identity_num")
    private String adminIdentityNum;


    @NotBlank(message = "商户管理员手机号码不能为空")
    @ApiModelProperty(value = "企业管理员或个人商户的手机号码",example = "18717919375")
    @TableField("admin_mob_phone")
    private String adminMobPhone;


    @NotBlank(message = "经营范围不能为空")
    @ApiModelProperty(value = "经营范围 以逗号隔开",example = "教育,文化,娱乐")
    @TableField("business_range")
    private String businessRange;
    /**
     * 企业管理员或个人商户的身份证的正面照片
     */
    @NotBlank(message = "企业管理员或个人商户的身份证的正面照片不能为空")
    @ApiModelProperty(value = "企业管理员或个人商户的身份证的正面照片",example = "xxx.png")
    @TableField("admin_identity_front_url")
    private String adminIdentityFrontUrl;


    @NotBlank(message = "业管理员或个人商户的身份证的背面照片不能为空")
    @ApiModelProperty(value = "企业管理员或个人商户的身份证的背面照片",example = "xxx.png")
    @TableField("admin_identity_back_url")
    private String adminIdentityBackUrl;


    @ApiModelProperty(value = "商户来源 0-用户添加,1-管理员自己添加",example = "0",hidden = true)
    @TableField("add_by")
    private Integer addBy;



    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除",example = "0",hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public SellerInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSn() {
        return sn;
    }

    public SellerInfo setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public SellerInfo setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public SellerInfo setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public SellerInfo setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getStateRemark() {
        return stateRemark;
    }

    public SellerInfo setStateRemark(String stateRemark) {
        this.stateRemark = stateRemark;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SellerInfo setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getAdminName() {
        return adminName;
    }

    public SellerInfo setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public String getAdminIdentityNum() {
        return adminIdentityNum;
    }

    public SellerInfo setAdminIdentityNum(String adminIdentityNum) {
        this.adminIdentityNum = adminIdentityNum;
        return this;
    }

    public String getAdminMobPhone() {
        return adminMobPhone;
    }

    public SellerInfo setAdminMobPhone(String adminMobPhone) {
        this.adminMobPhone = adminMobPhone;
        return this;
    }

    public String getBusinessRange() {
        return businessRange;
    }

    public SellerInfo setBusinessRange(String businessRange) {
        this.businessRange = businessRange;
        return this;
    }

    public String getAdminIdentityFrontUrl() {
        return adminIdentityFrontUrl;
    }

    public SellerInfo setAdminIdentityFrontUrl(String adminIdentityFrontUrl) {
        this.adminIdentityFrontUrl = adminIdentityFrontUrl;
        return this;
    }

    public String getAdminIdentityBackUrl() {
        return adminIdentityBackUrl;
    }

    public SellerInfo setAdminIdentityBackUrl(String adminIdentityBackUrl) {
        this.adminIdentityBackUrl = adminIdentityBackUrl;
        return this;
    }

    public Integer getAddBy() {
        return addBy;
    }

    public SellerInfo setAddBy(Integer addBy) {
        this.addBy = addBy;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public SellerInfo setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "SellerInfo{" +
        "id=" + id +
        ", sn=" + sn +
        ", userId=" + userId +
        ", logo=" + logo +
        ", state=" + state +
        ", stateRemark=" + stateRemark +
        ", type=" + type +
        ", adminName=" + adminName +
        ", adminIdentityNum=" + adminIdentityNum +
        ", adminMobPhone=" + adminMobPhone +
        ", businessRange=" + businessRange +
        ", adminIdentityFrontUrl=" + adminIdentityFrontUrl +
        ", adminIdentityBackUrl=" + adminIdentityBackUrl +
        ", addBy=" + addBy +
        ", delFlag=" + delFlag +
        "}";
    }
}
