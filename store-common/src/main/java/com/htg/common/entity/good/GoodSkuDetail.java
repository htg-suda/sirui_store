package com.htg.common.entity.good;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
@TableName("sr_good_sku_detail")
public class GoodSkuDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 商品sku_id ,参考商品sku 表
     */
    @ApiModelProperty(value = "商品sku id", hidden = true)
    @TableId("sku_id")
    private Integer skuId;
    /**
     * 商品副图,一个json 数组的字符串 xxxx.png;xxxx.png
     */
    // @NotBlank(message = "商品副图图片不能为空")
    @ApiModelProperty(value = "商品副图,", example = "xxxx.png;xxxx.png")
    @TableField("sub_img")
    private String subImg;
    /**
     * 商品描述详情,是一段html富文本
     */
    //  @NotBlank(message = "商品副图图片不能为空")
    @ApiModelProperty(value = "商品描述详情,是一段html富文本,", example = "<html>hello world</html>")
    @TableField("detail_desc")
    private String detailDesc;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getSkuId() {
        return skuId;
    }

    public GoodSkuDetail setSkuId(Integer skuId) {
        this.skuId = skuId;
        return this;
    }

    public String getSubImg() {
        return subImg;
    }

    public GoodSkuDetail setSubImg(String subImg) {
        this.subImg = subImg;
        return this;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public GoodSkuDetail setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public GoodSkuDetail setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "GoodSkuDetail{" +
                "skuId=" + skuId +
                ", subImg=" + subImg +
                ", detailDesc=" + detailDesc +
                ", delFlag=" + delFlag +
                "}";
    }
}
