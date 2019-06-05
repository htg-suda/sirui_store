package com.htg.common.vo.shop;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopGoodSpuVo {
    @ApiModelProperty(value = "商品spu id", hidden = true)
    private Integer id;

    @ApiModelProperty(value = "店铺id", example = "1", required = true)
    private Integer storeId;

    @ApiModelProperty(value = "品牌中文名", example = "邦德乐思", required = true)
    private String brandNameCN;

    @ApiModelProperty(value = "品牌英文名", example = "bdls", required = true)
    private String brandNameEG;

    @ApiModelProperty(value = "分类名", example = "手机", required = true)
    private String categoryName;

    @ApiModelProperty(value = "商品名或商品主标题", example = "iphone 6 plus", required = true)
    private String name;


    @ApiModelProperty(value = "商品spu的副标题", example = "iphone 6 plus")
    private String subTitle;

    @ApiModelProperty(value = "商品主图", example = "xxxx.png", required = true)
    private String mainImg;

    @ApiModelProperty(value = "促销类型 0-无促销 1-抢购 2-限时折扣", example = "0", required = true)
    private Integer promotionType;


    @ApiModelProperty(value = "付款人数", example = "0", required = true)
    private Integer payNum;


    @ApiModelProperty(value = "评价数量", example = "0", required = true)
    private Integer evaluateNum;


    @ApiModelProperty(value = "spu通用规格值", example = "{\"list\":[{\"groupId\":1,\"groupName\":\"位置\",\"items\":[{\"specItemId\":2,\"specName\":\"地址\",\"specItemValue\":\"浦江镇,浦晓南路51弄\",\"is_necessary\":1,\"is_general\":0}]},{}]}\n", dataType = "String", required = true)
    private String generalSpecValueSnapshot;


    @ApiModelProperty(value = "运费,0.00-包邮,免运费", example = "5.00", required = true)
    private BigDecimal freight;


    @ApiModelProperty(value = "商品状态: 0-下架(商家行为), 1-在售,10-违规被禁止售卖(管理员行为),一旦禁止售卖则无法上架", hidden = true)
    private Integer state;


    @ApiModelProperty(value = "违规原因", hidden = true)
    private String stateRemark;


    @ApiModelProperty(value = "商品审核 1-通过，0-未通过，10-审核中", hidden = true)
    private Integer verify;


    @ApiModelProperty(value = "审核不通过原因", hidden = true)
    private String verifyRemark;


    @ApiModelProperty(value = "包装清单", example = "包装清单", dataType = "String", required = true)
    private String packList;


    @Length(max = 255, message = "售后服务字数不能超过255")
    @ApiModelProperty(value = "售后服务", example = "售后服务,亲,提供上门安装服务哦", dataType = "String", required = true)
    private String afterSell;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getPayNum() {
        return payNum;
    }

    public void setPayNum(Integer payNum) {
        this.payNum = payNum;
    }

    public Integer getEvaluateNum() {
        return evaluateNum;
    }

    public void setEvaluateNum(Integer evaluateNum) {
        this.evaluateNum = evaluateNum;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateRemark() {
        return stateRemark;
    }

    public void setStateRemark(String stateRemark) {
        this.stateRemark = stateRemark;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public String getVerifyRemark() {
        return verifyRemark;
    }

    public void setVerifyRemark(String verifyRemark) {
        this.verifyRemark = verifyRemark;
    }

    public String getPackList() {
        return packList;
    }

    public void setPackList(String packList) {
        this.packList = packList;
    }

    public String getAfterSell() {
        return afterSell;
    }

    public void setAfterSell(String afterSell) {
        this.afterSell = afterSell;
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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getGeneralSpecValueSnapshot() {
        return generalSpecValueSnapshot;
    }

    public void setGeneralSpecValueSnapshot(String generalSpecValueSnapshot) {
        this.generalSpecValueSnapshot = generalSpecValueSnapshot;
    }
}
