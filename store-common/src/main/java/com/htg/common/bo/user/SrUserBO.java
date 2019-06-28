package com.htg.common.bo.user;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SrUserBO {
    @ApiModelProperty(value = "用户ID主键", example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名", example = "htg")
    private String username;

    @ApiModelProperty(value = "用户密码", example = "123qwe")
    private String password;

    @ApiModelProperty(value = "用户昵称", example = "123qwe")
    private String nikename;

    @ApiModelProperty(value = "用户手机号码", example = "18717919375")
    private String tel;

    @ApiModelProperty(value = "用户电子邮箱", example = "123@qq.com")
    private String email;

    @ApiModelProperty(value = " 用户年龄", example = "23")
    private Integer age;

    @ApiModelProperty(value = "性别 1-男 2-女 0-保密", example = "1")
    private Integer gender;

    @ApiModelProperty(value = "用户状态 1001-可用, 1002-不可用", example = "1001")
    private Integer status;

    @ApiModelProperty(value = "商户id,参考商户表", example = "1")
    private Integer sellerId;


    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", example = "0")
    private Integer delFlag;

    @ApiModelProperty(value = "用户组ID 列表")
    private List<Integer> groupIdList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }


    public List<Integer> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<Integer> groupIdList) {
        this.groupIdList = groupIdList;
    }

    @Override
    public String toString() {
        return "SrUserBO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nikename='" + nikename + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", status=" + status +
                ", sellerId=" + sellerId +
                ", delFlag=" + delFlag +
                ", groupIdList=" + groupIdList +
                '}';
    }
}
