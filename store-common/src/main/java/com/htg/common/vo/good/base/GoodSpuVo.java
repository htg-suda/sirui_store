package com.htg.common.vo.good.base;

import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>
 * 商品spu表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public class GoodSpuVo extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "商品spu id", example = "1")
    private Integer id;
    /**
     *
     */
    @ApiModelProperty(value = "店铺id", example = "1",   required = true)
    private Integer storeId;


    @NotNull(message = "分类id不能为空")
    private Integer categoryId;


    @ApiModelProperty(value = "品牌中文名", example = "邦德乐思")
    private String brandNameCN;

    @ApiModelProperty(value = "品牌英文名", example = "bdls")
    private String brandNameEG;

    @ApiModelProperty(value = "分类名", example = "手机")
    private String categoryName;

    @ApiModelProperty(value = "店铺名",example = "邦德旗舰店")
    private String storeName;

    @ApiModelProperty(value = "分类的id集合表如: 0/1/3", example = "0/1/3", required = true)
    private String cateIds;


    @ApiModelProperty(value = "品牌id", example = "1",   required = true)
    private Integer brandId;
    /**
     *
     */
    @ApiModelProperty(value = "商品名或商品主标题", example = "iphone 6 plus", required = true)
    private String name;


    @ApiModelProperty(value = "商品spu的副标题", example = "iphone 6 plus")
    private String subTitle;
    /**
     *
     */
    @ApiModelProperty(value = "商品主图", example = "xxxx.png", required = true)
    private String mainImg;


    @ApiModelProperty(value = "促销类型 0-无促销 1-抢购 2-限时折扣", example = "0", required = true)
    private Integer promotionType;


    @ApiModelProperty(value = "付款人数", example = "0", required = true)
    private Integer payNum;


    @ApiModelProperty(value = "评价数量", example = "0", required = true)
    private Integer evaluateNum;


    @ApiModelProperty(value = "运费", example = "5.00", required = true)
    private BigDecimal freight;


    @ApiModelProperty(value = "包装清单",example = "包装清单",  dataType = "String", required = true)
    private String packList;


    @ApiModelProperty(value = "售后服务",example = "售后服务,亲,提供上门安装服务哦",  dataType = "String", required = true)
    private String afterSell;



    public Integer getId() {
        return id;
    }

    public GoodSpuVo setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public GoodSpuVo setStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public GoodSpuVo setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getCateIds() {
        return cateIds;
    }

    public GoodSpuVo setCateIds(String cateIds) {
        this.cateIds = cateIds;
        return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public GoodSpuVo setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodSpuVo setName(String name) {
        this.name = name;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public GoodSpuVo setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public String getMainImg() {
        return mainImg;
    }

    public GoodSpuVo setMainImg(String mainImg) {
        this.mainImg = mainImg;
        return this;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public GoodSpuVo setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
        return this;
    }

    public Integer getPayNum() {
        return payNum;
    }

    public GoodSpuVo setPayNum(Integer payNum) {
        this.payNum = payNum;
        return this;
    }

    public Integer getEvaluateNum() {
        return evaluateNum;
    }

    public GoodSpuVo setEvaluateNum(Integer evaluateNum) {
        this.evaluateNum = evaluateNum;
        return this;
    }



    public BigDecimal getFreight() {
        return freight;
    }

    public GoodSpuVo setFreight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }


    public String getPackList() {
        return packList;
    }

    public GoodSpuVo setPackList(String packList) {
        this.packList = packList;
        return this;
    }

    public String getAfterSell() {
        return afterSell;
    }

    public GoodSpuVo setAfterSell(String afterSell) {
        this.afterSell = afterSell;
        return this;
    }


    public String getBrandNameCN() {
        return brandNameCN;
    }

    public void setBrandNameCN(String brandNameCN) {
        this.brandNameCN = brandNameCN;
    }

    public String getBrandNameEG() {
        return brandNameEG;
    }

    public void setBrandNameEG(String brandNameEG) {
        this.brandNameEG = brandNameEG;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "GoodSpuVo{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", categoryId=" + categoryId +
                ", brandNameCN='" + brandNameCN + '\'' +
                ", brandNameEG='" + brandNameEG + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", storeName='" + storeName + '\'' +
                ", cateIds='" + cateIds + '\'' +
                ", brandId=" + brandId +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", mainImg='" + mainImg + '\'' +
                ", promotionType=" + promotionType +
                ", payNum=" + payNum +
                ", evaluateNum=" + evaluateNum +
                ", freight=" + freight +
                ", packList='" + packList + '\'' +
                ", afterSell='" + afterSell + '\'' +
                '}';
    }
}
