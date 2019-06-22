package com.htg.common.entity.seller;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 商铺表
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
@TableName("sr_seller_store")
public class SellerStore extends BaseEntity {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "店铺id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "店铺名不能为空")
    @ApiModelProperty(value = "店铺名", example = "邦德乐思旗舰店")
    @TableField("name")
    private String name;

    @NotBlank(message = "店铺logo不能为空")
    @ApiModelProperty(value = "店铺logo", example = "xxxx.png")
    @TableField("logo")
    private String logo;
    /**
     * 商户编号
     */
    @ApiModelProperty(value = "商户编号,uuid ,参考商户表", example = "uuid", hidden = true)
    @TableField("seller_sn")
    private String sellerSn;



    @ApiModelProperty(value = "店铺等级1~5", example = "1", hidden = true)
    @TableField("level")
    private Integer level;



    @ApiModelProperty(value = "店铺状态 0-未激活, 1-已激活 10-冻结", example = "1", hidden = true)
    @TableField("status")
    private Integer status;
    /**
     * 状态说明 ,比如冻结原因
     */
    @ApiModelProperty(value = "状态说明 ,比如冻结原因", example = "logo 太丑了", hidden = true)
    @TableField("status_remark")
    private String statusRemark;




    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除",example = "0",hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public SellerStore setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SellerStore setName(String name) {
        this.name = name;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public SellerStore setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public String getSellerSn() {
        return sellerSn;
    }

    public SellerStore setSellerSn(String sellerSn) {
        this.sellerSn = sellerSn;
        return this;
    }


    public Integer getLevel() {
        return level;
    }

    public SellerStore setLevel(Integer level) {
        this.level = level;
        return this;
    }


    public Integer getStatus() {
        return status;
    }

    public SellerStore setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getStatusRemark() {
        return statusRemark;
    }

    public SellerStore setStatusRemark(String statusRemark) {
        this.statusRemark = statusRemark;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public SellerStore setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "SellerStore{" +
                "id=" + id +
                ", name=" + name +
                ", logo=" + logo +
                ", sellerSn=" + sellerSn +
                ", level=" + level +
                ", status=" + status +
                ", statusRemark=" + statusRemark +
                ", delFlag=" + delFlag +
                "}";
    }
}
