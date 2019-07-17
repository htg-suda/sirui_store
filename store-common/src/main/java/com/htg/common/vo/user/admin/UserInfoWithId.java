package com.htg.common.vo.user.admin;

import com.htg.common.vo.user.user.UserInfo;
import io.swagger.annotations.ApiModelProperty;

public class UserInfoWithId extends UserInfo {
    @ApiModelProperty(value = "用户ID主键", example = "1")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserInfoWithId{" +
                "id=" + id +
                '}';
    }
}
