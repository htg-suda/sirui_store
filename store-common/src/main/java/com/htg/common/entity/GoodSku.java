package com.htg.common.entity;

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
 * @since 2019-05-29
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
     * 商品的名字,或则标题
     */
    @TableField("name")
    private String name;
    /**
     * 具体的商品的图片
     */
    @TableField("images")
    private String images;
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
     * sku 商品特有的规格参数值 ,比如某一款手机为红色
     */
    @TableField("own_spec")
    private String ownSpec;
    /**
     * 商品描述详情,是一段html富文本
     */
    @TableField("detail_desc")
    private String detailDesc;
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

    public String getName() {
        return name;
    }

    public GoodSku setName(String name) {
        this.name = name;
        return this;
    }

    public String getImages() {
        return images;
    }

    public GoodSku setImages(String images) {
        this.images = images;
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

    public String getOwnSpec() {
        return ownSpec;
    }

    public GoodSku setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
        return this;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public GoodSku setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
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
        ", name=" + name +
        ", images=" + images +
        ", price=" + price +
        ", promotionPrice=" + promotionPrice +
        ", marketPrice=" + marketPrice +
        ", ownSpec=" + ownSpec +
        ", detailDesc=" + detailDesc +
        ", status=" + status +
        ", delFlag=" + delFlag +
        "}";
    }
}
