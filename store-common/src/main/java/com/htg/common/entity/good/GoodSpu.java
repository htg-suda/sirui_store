package com.htg.common.entity.good;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
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
@TableName("sr_good_spu")
public class GoodSpu extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "商品spu id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *
     */
    @NotNull(message = "店铺id,参考店铺表")
    @ApiModelProperty(value = "店铺id", example = "1",   required = true)
    @TableField("store_id")
    private Integer storeId;


    @NotNull(message = "分类id不能为空")
    @ApiModelProperty(value = "分类id", example = "1",  required = true)
    @TableField("category_id")
    private Integer categoryId;



    @NotBlank(message = "分类的id集合,不能为空")
    @ApiModelProperty(value = "分类的id集合表如: 0/1/3", example = "0/1/3", required = true)
    @TableField("cate_ids")
    private String cateIds;


    @NotNull(message = "品牌id不能为空")
    @ApiModelProperty(value = "品牌id", example = "1",   required = true)
    @TableField("brand_id")
    private Integer brandId;
    /**
     *
     */
    @NotBlank(message = "商品名不能为空")
    @ApiModelProperty(value = "商品名或商品主标题", example = "iphone 6 plus", required = true)
    @TableField("name")
    private String name;


    @ApiModelProperty(value = "商品spu的副标题", example = "iphone 6 plus")
    @TableField("sub_title")
    private String subTitle;
    /**
     *
     */
    @NotBlank(message = "商品主图不能为空")
    @ApiModelProperty(value = "商品主图", example = "xxxx.png", required = true)
    @TableField("main_img")
    private String mainImg;


    @NotNull(message = "促销类型,不能为空")
    @ApiModelProperty(value = "促销类型 0-无促销 1-抢购 2-限时折扣", example = "0", required = true)
    @TableField("promotion_type")
    private Integer promotionType;


    @ApiModelProperty(value = "付款人数", example = "0", required = true)
    @TableField("pay_num")
    private Integer payNum;


    @ApiModelProperty(value = "评价数量", example = "0", required = true)
    @TableField("evaluate_num")
    private Integer evaluateNum;
    /**
     * spu 通用规格值 {list:[{"specItemId":2,"specItemValue":"1209","is_necessary":1,"is_general":0}]}
     */


    @NotNull(message = "运费不能为空")
    @Digits(integer = 10,fraction = 2, message = "运费需要保留两位有效数字,0.00表示包邮")
    @ApiModelProperty(value = "运费,0.00-包邮,免运费", example = "5.00", required = true)
    @TableField("freight")
    private BigDecimal freight;



    @ApiModelProperty(value = "商品状态: 0-下架(商家行为), 1-上架在售, 2-待售卖 ,10-违规被禁止售卖(管理员行为),一旦禁止售卖则无法上架,20-解禁,解禁后可以重新上架", hidden = true)
    @TableField("state")
    private Integer state;

    @Length(max = 100,message = "违规原因字数不能超过100")
    @ApiModelProperty(value = "违规原因", hidden = true)
    @TableField("state_remark")
    private String stateRemark;


    @ApiModelProperty(value = "商品审核 1-通过，0-未通过，10-审核中", hidden = true)
    @TableField("verify")
    private Integer verify;


    @Length(max = 100,message = "审核不通过原因字数不能超过100")
    @ApiModelProperty(value = "审核不通过原因", hidden = true)
    @TableField("verify_remark")
    private String verifyRemark;
    /**
     *
     */
    @Length(max = 255,message = "包装清单字数不能超过255")
    @ApiModelProperty(value = "包装清单",example = "包装清单",  dataType = "String", required = true)
    @TableField("pack_list")
    private String packList;


    @Length(max = 255,message = "售后服务字数不能超过255")
    @ApiModelProperty(value = "售后服务",example = "售后服务,亲,提供上门安装服务哦",  dataType = "String", required = true)
    @TableField("after_sell")
    private String afterSell;


    @ApiModelProperty(value = "删除状态,0-有效,-1 -删除", example = "10", name = "sort", dataType = "int", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public GoodSpu setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public GoodSpu setStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public GoodSpu setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getCateIds() {
        return cateIds;
    }

    public GoodSpu setCateIds(String cateIds) {
        this.cateIds = cateIds;
        return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public GoodSpu setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodSpu setName(String name) {
        this.name = name;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public GoodSpu setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public String getMainImg() {
        return mainImg;
    }

    public GoodSpu setMainImg(String mainImg) {
        this.mainImg = mainImg;
        return this;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public GoodSpu setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
        return this;
    }

    public Integer getPayNum() {
        return payNum;
    }

    public GoodSpu setPayNum(Integer payNum) {
        this.payNum = payNum;
        return this;
    }

    public Integer getEvaluateNum() {
        return evaluateNum;
    }

    public GoodSpu setEvaluateNum(Integer evaluateNum) {
        this.evaluateNum = evaluateNum;
        return this;
    }



    public BigDecimal getFreight() {
        return freight;
    }

    public GoodSpu setFreight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public GoodSpu setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getStateRemark() {
        return stateRemark;
    }

    public GoodSpu setStateRemark(String stateRemark) {
        this.stateRemark = stateRemark;
        return this;
    }

    public Integer getVerify() {
        return verify;
    }

    public GoodSpu setVerify(Integer verify) {
        this.verify = verify;
        return this;
    }

    public String getVerifyRemark() {
        return verifyRemark;
    }

    public GoodSpu setVerifyRemark(String verifyRemark) {
        this.verifyRemark = verifyRemark;
        return this;
    }

    public String getPackList() {
        return packList;
    }

    public GoodSpu setPackList(String packList) {
        this.packList = packList;
        return this;
    }

    public String getAfterSell() {
        return afterSell;
    }

    public GoodSpu setAfterSell(String afterSell) {
        this.afterSell = afterSell;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public GoodSpu setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "GoodSpu{" +
        "id=" + id +
        ", storeId=" + storeId +
        ", categoryId=" + categoryId +
        ", cateIds=" + cateIds +
        ", brandId=" + brandId +
        ", name=" + name +
        ", subTitle=" + subTitle +
        ", mainImg=" + mainImg +
        ", promotionType=" + promotionType +
        ", payNum=" + payNum +
        ", evaluateNum=" + evaluateNum +
        ", freight=" + freight +
        ", state=" + state +
        ", stateRemark=" + stateRemark +
        ", verify=" + verify +
        ", verifyRemark=" + verifyRemark +
        ", packList=" + packList +
        ", afterSell=" + afterSell +
        ", delFlag=" + delFlag +
        "}";
    }
}
