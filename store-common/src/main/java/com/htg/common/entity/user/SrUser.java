package com.htg.common.entity.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author htg
 * @since 2019-06-13
 */
@TableName("sr_user")
public class SrUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID主键", example = "1", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{5,16}$", message = "由字母数字下划线组成且开头必须是字母,位数5~16位")
    @ApiModelProperty(value = "用户名", example = "htg")
    @TableField("username")
    private String username;


    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "密码必须是字母和数字的组合,且位数为6~20位")
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "用户密码", example = "123qwe")
    @TableField("password")
    private String password;


    @Length(max = 16, min = 1, message = "用户昵称长度不可大于16位")
    @ApiModelProperty(value = "用户昵称", example = "123qwe")
    @TableField("nikename")
    private String nikename;


    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$",
            message = "用户手机号码不合法")
    @ApiModelProperty(value = "用户手机号码", example = "18717919375")
    @TableField("tel")
    private String tel;


    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message = "用户电子邮箱不合法")
    @ApiModelProperty(value = "用户电子邮箱", example = "123@qq.com")
    @TableField("email")
    private String email;


    @Min(value = 0, message = "年龄不可小于0")
    @Max(value = 200, message = "年龄不可大于200")
    @ApiModelProperty(value = " 用户年龄", example = "23")
    @TableField("age")
    private Integer age;


    @ApiModelProperty(value = "性别 1-男 2-女 0-保密", example = "1")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty(value = "用户状态 1001-可用, 1002-不可用", example = "1001", hidden = true)
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "商户id,参考商户表", example = "1")
    @TableField("seller_id")
    private Integer sellerId;



    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", example = "0", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public SrUser setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SrUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SrUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNikename() {
        return nikename;
    }

    public SrUser setNikename(String nikename) {
        this.nikename = nikename;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public SrUser setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SrUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public SrUser setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public SrUser setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public SrUser setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public SrUser setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "SrUser{" +
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
                '}';
    }
}
