package com.htg.common.entity.auth;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author htg
 * @since 2019-06-10
 */
@TableName("group_permission_mapping")
public class GroupPermissionMapping extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限分组 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 权限组Id
     */
    @TableField("group_id")
    private Integer groupId;
    /**
     * 权限 id
     */
    @TableField("permission_id")
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public GroupPermissionMapping setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public GroupPermissionMapping setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public GroupPermissionMapping setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    @Override
    public String toString() {
        return "GroupPermissionMapping{" +
        "id=" + id +
        ", groupId=" + groupId +
        ", permissionId=" + permissionId +
        "}";
    }
}
