package com.htg.common.vo.user.admin;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class CustomServiceUserInfoVo {
    @ApiModelProperty(value = "用户手机号码", example = "18717919375")
    private String tel;

    @ApiModelProperty(value = "创建时间", example = "2019-09-23")
    private Date createTime;


    @ApiModelProperty(value = "客服昵称", example = "会飞的鱼")
    private String serviceName;


    @ApiModelProperty(value = "客服ID", example = "1")
    private Integer id;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
