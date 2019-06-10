package com.htg.common.entity.good;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商品sku库存表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@TableName("sr_good_sku_stock")
public class GoodSkuStock extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 参考商品的sku 表,和sku表一对一的关系
     */
    @ApiModelProperty(value = "商品SKU ID", hidden = true)
    @TableField("sku_id")
    private Integer skuId;
    /**
     * 商品的库存总量
     */
    @NotNull(message = "商品库存不能为空")
    @ApiModelProperty(value = "商品库存", example = "9999")
    @TableField("stock")
    private Integer stock;
    /**
     * 库存警戒值
     */
    @ApiModelProperty(value = "库存警戒值", example = "5")
    @TableField("stock_alarm")
    private Integer stockAlarm;

    /**
     * 删除状态,0-有效,-1 -删除
     */
    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getSkuId() {
        return skuId;
    }

    public GoodSkuStock setSkuId(Integer skuId) {
        this.skuId = skuId;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public GoodSkuStock setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public Integer getStockAlarm() {
        return stockAlarm;
    }

    public GoodSkuStock setStockAlarm(Integer stockAlarm) {
        this.stockAlarm = stockAlarm;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public GoodSkuStock setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "GoodSkuStock{" +
                "skuId=" + skuId +
                ", stock=" + stock +
                ", stockAlarm=" + stockAlarm +
                ", delFlag=" + delFlag +
                "}";
    }
}
