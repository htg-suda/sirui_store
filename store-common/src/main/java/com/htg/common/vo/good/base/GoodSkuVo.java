package com.htg.common.vo.good.base;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
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
public class GoodSkuVo extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 商品sku id
     */
    @ApiModelProperty(value = "商品sku id", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 商品的spu id ,spu 和 sku 是一对多关系
     */
    @NotNull(message = "商品SPU id 不能为空 ")
    @ApiModelProperty(value = "商品SPU id", example = "1")
    @TableField("spu_id")
    private Integer spuId;


    @ApiModelProperty(value = "商品sku 编码", example = "UUID")
    @TableField("sku_num")
    private String skuNum;
    /**
     * 商品sku收藏数量
     */
    @ApiModelProperty(value = "收藏数量", example = "0")
    @TableField("collect_num")
    private Integer collectNum;
    /**
     * 商品的名字,或则标题
     */
    @NotBlank(message = "商品名||标题不能为空")
    @ApiModelProperty(value = "商品的名字,或则标题", example = "iPhone 金色")
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


    public Integer getId() {
        return id;
    }

    public GoodSkuVo setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public GoodSkuVo setSpuId(Integer spuId) {
        this.spuId = spuId;
        return this;
    }


    public Integer getCollectNum() {
        return collectNum;
    }

    public GoodSkuVo setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodSkuVo setName(String name) {
        this.name = name;
        return this;
    }

    public String getMainImage() {
        return mainImage;
    }

    public GoodSkuVo setMainImage(String mainImage) {
        this.mainImage = mainImage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public GoodSkuVo setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public GoodSkuVo setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
        return this;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public GoodSkuVo setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
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
                '}';
    }
}
