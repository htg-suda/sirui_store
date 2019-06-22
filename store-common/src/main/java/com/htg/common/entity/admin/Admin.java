package com.htg.common.entity.admin;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author htg
 * @since 2019-06-09
 */
@TableName("sr_admin")
public class Admin extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员ID ,主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 管理员组id , group_id 为 0 是超级管理员 
     */
    @TableField("group_id")
    private Integer groupId;
    /**
     * 管理员名
     */
    @TableField("admin_name")
    private String adminName;
    /**
     * 管理员密码
     */
    @TableField("admin_password")
    private String adminPassword;
    /**
     * 用户手机号码
     */
    @TableField("tel")
    private String tel;
    /**
     * 用户电子邮箱
     */
    @TableField("email")
    private String email;
    /**
     * 管理员状态 1001-可用, 1002-不可用
     */
    @TableField("status")
    private Integer status;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public Admin setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public Admin setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getAdminName() {
        return adminName;
    }

    public Admin setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public Admin setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public Admin setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Admin setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Admin setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Admin setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "Admin{" +
        "id=" + id +
        ", groupId=" + groupId +
        ", adminName=" + adminName +
        ", adminPassword=" + adminPassword +
        ", tel=" + tel +
        ", email=" + email +
        ", status=" + status +
        ", delFlag=" + delFlag +
        "}";
    }
}
