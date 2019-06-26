package com.htg.common.dto.custom;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomSearchDto {
    @ApiModelProperty(value = "客服昵称", example = "会飞的鱼", required = true)
    private String serviceName;

    @NotNull(message = "每页的数据量不可为空")
    @ApiModelProperty(value = "每页的数据量", example = "5")
    private Integer pageSize;

    @NotNull(message = "第几页不可为空")
    @ApiModelProperty(value = "第几页", example = "1")
    private Integer pageNum;

    @Pattern(regexp = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$",
            message = "用户手机号码不合法")
    @ApiModelProperty(value = "用户手机号码", example = "18717919375")
    private String tel;


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

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

    @Override
    public String toString() {
        return "CustomSearchDto{" +
                "serviceName='" + serviceName + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", tel='" + tel + '\'' +
                '}';
    }
}
