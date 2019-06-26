package com.htg.common.entity.custom;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 客服信息表
 * </p>
 *
 * @author htg
 * @since 2019-06-25
 */
@TableName("sr_custom_service_info")
public class CustomServiceInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 客服ID
     */
    @ApiModelProperty(hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id, 参考用户id表
     */
    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户id", example = "1", required = true)
    @TableField("user_id")
    private Integer userId;
    /**
     *
     */
    @NotBlank(message = "客服昵称不能为空")
    @ApiModelProperty(value = "客服昵称", example = "会飞的鱼", required = true)
    @TableField("service_name")
    private String serviceName;
    /**
     * 删除状态
     */
    @ApiModelProperty(hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public CustomServiceInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public CustomServiceInfo setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public CustomServiceInfo setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public CustomServiceInfo setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "CustomServiceInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceName=" + serviceName +
                ", delFlag=" + delFlag +
                "}";
    }
}
