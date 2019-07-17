package com.htg.common.vo.user.user;

import io.swagger.annotations.ApiModelProperty;

public class UserInfo {
    @ApiModelProperty(value = "用户名",example = "BD_xyz123")
    private String username;

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



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", nikename='" + nikename + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +

                '}';
    }
}
