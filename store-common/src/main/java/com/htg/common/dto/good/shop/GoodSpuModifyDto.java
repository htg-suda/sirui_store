package com.htg.common.dto.good.shop;

import com.baomidou.mybatisplus.annotations.TableField;
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

public class GoodSpuModifyDto extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "商品spu id,不能为空")
    @ApiModelProperty(value = "商品spu id", example = "1",  dataType = "int", required = true)
    private Integer id;


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




    @NotNull(message = "运费不能为空")
    @Digits(integer = 10,fraction = 2, message = "运费需要保留两位有效数字,0.00表示包邮")
    @ApiModelProperty(value = "运费,0.00-包邮,免运费", example = "5.00", required = true)
    @TableField("freight")
    private BigDecimal freight;

    @ApiModelProperty(value = "商品状态: 0-下架(商家行为), 1-在售,10-违规被禁止售卖(管理员行为),一旦禁止售卖则无法上架", hidden = true)
    @TableField("state")
    private Integer state;

    @Length(max = 255,message = "包装清单字数不能超过255")
    @ApiModelProperty(value = "包装清单",example = "包装清单", required = true)
    @TableField("pack_list")
    private String packList;


    @Length(max = 255,message = "售后服务字数不能超过255")
    @ApiModelProperty(value = "售后服务",example = "售后服务,亲,提供上门安装服务哦", required = true)
    @TableField("after_sell")
    private String afterSell;



    public Integer getId() {
        return id;
    }

    public GoodSpuModifyDto setId(Integer id) {
        this.id = id;
        return this;
    }



    public String getName() {
        return name;
    }

    public GoodSpuModifyDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public GoodSpuModifyDto setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public String getMainImg() {
        return mainImg;
    }

    public GoodSpuModifyDto setMainImg(String mainImg) {
        this.mainImg = mainImg;
        return this;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public GoodSpuModifyDto setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
        return this;
    }


    public BigDecimal getFreight() {
        return freight;
    }

    public GoodSpuModifyDto setFreight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public GoodSpuModifyDto setState(Integer state) {
        this.state = state;
        return this;
    }



    public String getPackList() {
        return packList;
    }

    public GoodSpuModifyDto setPackList(String packList) {
        this.packList = packList;
        return this;
    }

    public String getAfterSell() {
        return afterSell;
    }

    public GoodSpuModifyDto setAfterSell(String afterSell) {
        this.afterSell = afterSell;
        return this;
    }
}
