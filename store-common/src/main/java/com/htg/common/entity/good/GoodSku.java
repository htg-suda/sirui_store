package com.htg.common.entity.good;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

import java.math.BigDecimal;

/**
 * <p>
 * 商品的sku 表,具体到某一款商品
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
@TableName("sr_good_sku")
public class GoodSku extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 商品sku id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 商品的spu id ,spu 和 sku 是一对多关系
     */
    @TableField("spu_id")
    private Integer spuId;
    /**
     * 商品spu 编码
     */
    @TableField("spu_num")
    private String spuNum;
    /**
     * 商品sku收藏数量
     */
    @TableField("collect_num")
    private Integer collectNum;
    /**
     * 商品的名字,或则标题
     */
    @TableField("name")
    private String name;
    /**
     * 具体的商品的图片
     */
    @TableField("main_image")
    private String mainImage;
    /**
     * 商品价格
     */
    @TableField("price")
    private BigDecimal price;
    /**
     * 促销价格
     */
    @TableField("promotion_price")
    private BigDecimal promotionPrice;
    /**
     * 市场价格
     */
    @TableField("market_price")
    private BigDecimal marketPrice;
    /**
     * 0- 商品有效,-1 商品无效
     */
    @TableField("status")
    private Integer status;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public GoodSku setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public GoodSku setSpuId(Integer spuId) {
        this.spuId = spuId;
        return this;
    }

    public String getSpuNum() {
        return spuNum;
    }

    public GoodSku setSpuNum(String spuNum) {
        this.spuNum = spuNum;
        return this;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public GoodSku setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodSku setName(String name) {
        this.name = name;
        return this;
    }

    public String getMainImage() {
        return mainImage;
    }

    public GoodSku setMainImage(String mainImage) {
        this.mainImage = mainImage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public GoodSku setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public GoodSku setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
        return this;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public GoodSku setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public GoodSku setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public GoodSku setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "GoodSku{" +
        "id=" + id +
        ", spuId=" + spuId +
        ", spuNum=" + spuNum +
        ", collectNum=" + collectNum +
        ", name=" + name +
        ", mainImage=" + mainImage +
        ", price=" + price +
        ", promotionPrice=" + promotionPrice +
        ", marketPrice=" + marketPrice +
        ", status=" + status +
        ", delFlag=" + delFlag +
        "}";
    }
}
