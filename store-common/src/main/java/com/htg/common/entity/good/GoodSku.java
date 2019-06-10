package com.htg.common.entity.good;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @ApiModelProperty(value = "商品sku id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 商品的spu id ,spu 和 sku 是一对多关系
     */
    @NotNull(message = "商品SPU id 不能为空 ")
    @ApiModelProperty(value = "商品SPU id", example = "1", required = true)
    @TableField("spu_id")
    private Integer spuId;


    @ApiModelProperty(value = "商品sku 编码", example = "UUID", hidden = true)
    @TableField("sku_num")
    private String skuNum;
    /**
     * 商品sku收藏数量
     */
    @ApiModelProperty(value = "收藏数量", example = "0", hidden = true)
    @TableField("collect_num")
    private Integer collectNum;
    /**
     * 商品的名字,或则标题
     */
    @NotBlank(message = "商品名||标题不能为空")
    @ApiModelProperty(value = "商品的名字,或则标题", example = "Iphone 金色")
    @TableField("name")
    private String name;
    /**
     * 具体的商品的图片
     */
    @NotBlank(message = "商品主图片不能为空")
    @ApiModelProperty(value = "商品主图片", example = "xxxxx.png")
    @TableField("main_image")
    private String mainImage;
    /**
     *
     */
    @Digits(integer = 10, fraction = 2, message = "商品价格需要保留两位有效数字")
    @ApiModelProperty(value = "商品价格", example = "0.50", required = true)
    @TableField("price")
    private BigDecimal price;



    @Digits(integer = 10, fraction = 2, message = "商品促销价格需要保留两位有效数字")
    @ApiModelProperty(value = "促销价格", example = "0.50")
    @TableField("promotion_price")
    private BigDecimal promotionPrice;
    /**
     * 市场价格
     */
    @Digits(integer = 10, fraction = 2, message = "商品市场价格需要保留两位有效数字")
    @ApiModelProperty(value = " 市场价格", example = "0.50")
    @TableField("market_price")
    private BigDecimal marketPrice;


    @ApiModelProperty(value = "商品状态, 0- 商品有效,-1 商品无效", hidden = true)
    @TableField("status")
    private Integer status;



    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", hidden = true)
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

    public String getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(String skuNum) {
        this.skuNum = skuNum;
    }

    @Override
    public String toString() {
        return "GoodSkuVo{" +
                "id=" + id +
                ", spuId=" + spuId +
                ", skuNum='" + skuNum + '\'' +
                ", collectNum=" + collectNum +
                ", name='" + name + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", price=" + price +
                ", promotionPrice=" + promotionPrice +
                ", marketPrice=" + marketPrice +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
