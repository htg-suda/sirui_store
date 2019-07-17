package com.htg.common.vo.seller.system;
import io.swagger.annotations.ApiModelProperty;

public class SysSellerListItem {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户id")
    private Integer id;

    @ApiModelProperty(value = "商户编号,uuid ,参考商户表", example = "uuid")
    private String sn;

    /**
     * 用户id,参考用户表
     */
    @ApiModelProperty(value = "用户id,参考用户表", example = "0")
    private Integer userId;

    @ApiModelProperty(value = "商户logo", example = "xxxx.png")
    private String logo;


    @ApiModelProperty(value = " 0-待审核,1-审核通过已激活,-1 申请未通过 ,10-商户冻结", example = "1")
    private Integer state;


    @ApiModelProperty(value = "冻结原因或申请未通过原因", example = "logo 太难看了啊")
    private String stateRemark;

    @ApiModelProperty(value = "商户类型,0-企业商户 1-个人商户", example = "0")
    private Integer type;


    @ApiModelProperty(value = "管理员的姓名,必须是身份证上的姓名", example = "招財貓")
    private String adminName;


    @ApiModelProperty(value = "企业管理员或个人商户的手机号码", example = "18717919375")
    private String adminMobPhone;


    @ApiModelProperty(value = "商户来源 0-用户添加,1-管理员自己添加", example = "0")
    private Integer addBy;


    @ApiModelProperty(value = "企业名,必须是营业执照上的", example = "邦德乐思")
    private String enterpriseName;


    @ApiModelProperty(value = "企业登录名", example = "BD_ls0")
    private String username;


    @ApiModelProperty(value = "用户昵称", example = "蓝色忧郁")
    private String nikename;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateRemark() {
        return stateRemark;
    }

    public void setStateRemark(String stateRemark) {
        this.stateRemark = stateRemark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminMobPhone() {
        return adminMobPhone;
    }

    public void setAdminMobPhone(String adminMobPhone) {
        this.adminMobPhone = adminMobPhone;
    }

    public Integer getAddBy() {
        return addBy;
    }

    public void setAddBy(Integer addBy) {
        this.addBy = addBy;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    @Override
    public String toString() {
        return "SysSellerListItem{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", userId=" + userId +
                ", logo='" + logo + '\'' +
                ", state=" + state +
                ", stateRemark='" + stateRemark + '\'' +
                ", type=" + type +
                ", adminName='" + adminName + '\'' +
                ", adminMobPhone='" + adminMobPhone + '\'' +
                ", addBy=" + addBy +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", username='" + username + '\'' +
                ", nikename='" + nikename + '\'' +
                '}';
    }
}
