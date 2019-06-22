package com.htg.common.entity.user;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

/**
 * <p>
 * 用户角色组
 * </p>
 *
 * @author htg
 * @since 2019-06-14
 */
@TableName("tb_user_role_group")
public class UserRoleGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色组id ,主键自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 用户组所在的id
     */
    @TableField("role_group_id")
    private Integer roleGroupId;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public UserRoleGroup setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserRoleGroup setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getRoleGroupId() {
        return roleGroupId;
    }

    public UserRoleGroup setRoleGroupId(Integer roleGroupId) {
        this.roleGroupId = roleGroupId;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public UserRoleGroup setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "UserRoleGroup{" +
        "id=" + id +
        ", userId=" + userId +
        ", roleGroupId=" + roleGroupId +
        ", delFlag=" + delFlag +
        "}";
    }
}
