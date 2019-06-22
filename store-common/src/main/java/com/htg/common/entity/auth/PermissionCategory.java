package com.htg.common.entity.auth;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;

/**
 * <p>
 * 权限分类表
 * </p>
 *
 * @author htg
 * @since 2019-06-10
 */
@TableName("permission_category")
public class PermissionCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限分类id
     */
    @TableId("id")
    private Integer id;
    /**
     * 权限分类名
     */
    @TableField("name")
    private String name;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public PermissionCategory setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PermissionCategory setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PermissionCategory setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "PermissionCategory{" +
        "id=" + id +
        ", name=" + name +
        ", delFlag=" + delFlag +
        "}";
    }
}
