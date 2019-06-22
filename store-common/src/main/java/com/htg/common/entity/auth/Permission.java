package com.htg.common.entity.auth;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.htg.common.base.BaseEntity;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author htg
 * @since 2019-06-10
 */
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId("id")
    private Integer id;
    /**
     * 分类id
     */
    @TableField("category_id")
    private Integer categoryId;
    /**
     * 权限名
     */
    @TableField("name")
    private String name;
    /**
     * 权限码,用户后端权鉴,如商品管理就是: sys:good:manage
     */
    @TableField("code")
    private String code;
    /**
     * 权限的url地址
     */
    @TableField("resource")
    private String resource;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public Permission setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Permission setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Permission setCode(String code) {
        this.code = code;
        return this;
    }

    public String getResource() {
        return resource;
    }

    public Permission setResource(String resource) {
        this.resource = resource;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Permission setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "Permission{" +
        "id=" + id +
        ", categoryId=" + categoryId +
        ", name=" + name +
        ", code=" + code +
        ", resource=" + resource +
        ", delFlag=" + delFlag +
        "}";
    }
}
