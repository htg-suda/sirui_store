package com.htg.common.dto.seller.system;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class SellerListDto {
    @NotNull(message = "每个页面的数量不能为空")
    @ApiModelProperty(value = "每个页面的数量", example = "5")
    private Integer pageSize;
    @NotNull(message = "第几页不能为空")
    @ApiModelProperty(value = "第几页", example = "1")
    private Integer pageNum;

    @ApiModelProperty(value = "企业名称/个人", example = "0")
    private String sellerName;

    @ApiModelProperty(value = " 0-待审核,1-审核通过已激活,-1 申请未通过 ,10-商户冻结", example = "0")
    private Integer state;

    @ApiModelProperty(value = "商户类型,0-企业商户 1-个人商户", example = "0")
    private Integer type;

    @ApiModelProperty(value = "商户来源 0-用户添加,1-管理员自己添加", example = "0")
    private Integer addBy;

    @ApiModelProperty(value = "手机号码", example = "18717919275")
    private String tel;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAddBy() {
        return addBy;
    }

    public void setAddBy(Integer addBy) {
        this.addBy = addBy;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
