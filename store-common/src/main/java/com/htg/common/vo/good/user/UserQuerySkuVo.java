package com.htg.common.vo.good.user;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class UserQuerySkuVo {
    @ApiModelProperty(value = "商品sku id", example = "1")
    private Integer id;
    /**
     * 商品的spu id ,spu 和 sku 是一对多关系
     */
    @ApiModelProperty(value = "商品SPU id", example = "1")
    private Integer spuId;


    @ApiModelProperty(value = "商品sku 编码", example = "UUID")
    private String skuNum;
    /**
     * 商品sku收藏数量
     */
    @ApiModelProperty(value = "收藏数量", example = "0")
    private Integer collectNum;
    /**
     * 商品的名字,或则标题
     */
    @ApiModelProperty(value = "商品的名字,或则标题", example = "iPhone 金色")
    private String name;
    /**
     * 具体的商品的图片
     */
    @ApiModelProperty(value = "商品主图片", example = "xxxxx.png")
    private String mainImage;
    /**
     *
     */
    @ApiModelProperty(value = "商品价格", example = "0.50", required = true)
    private BigDecimal price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public String getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(String skuNum) {
        this.skuNum = skuNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
