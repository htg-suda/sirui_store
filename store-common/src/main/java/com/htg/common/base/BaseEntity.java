package com.htg.common.base;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


public class BaseEntity<T> implements Serializable {
    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(value = "create_time" ,fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    /**
     * 创建人的id
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Integer createUser;
    /**
     * 更新人的id
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    private Integer updateUser;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
