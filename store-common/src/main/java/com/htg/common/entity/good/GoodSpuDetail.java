package com.htg.common.entity.good;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 商品spu详情表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@TableName("sr_good_spu_detail")
public class GoodSpuDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "商品spu_id ,参考商品spu表", hidden = true)
    @TableId("spu_id")
    private Integer spuId;


    @ApiModelProperty(value = " 商品副图,字符串", example = "xxxx.png;xxxx.png")
    @TableField("sub_img")
    private String subImg;


    @NotBlank(message = "商品详情不能为空")
    @ApiModelProperty(value = " 商品描述详情,是一段html富文本", example = "<html>hello world</html>", required = true)
    @TableField("detail_desc")
    private String detailDesc;


    @ApiModelProperty(value = "商品收藏数量", example = "0", hidden = true)
    @TableField("collect_num")
    private Integer collectNum;


    @ApiModelProperty(value = " 删除状态,0-有效,-1 -删除", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getSpuId() {
        return spuId;
    }

    public GoodSpuDetail setSpuId(Integer spuId) {
        this.spuId = spuId;
        return this;
    }

    public String getSubImg() {
        return subImg;
    }

    public GoodSpuDetail setSubImg(String subImg) {
        this.subImg = subImg;
        return this;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public GoodSpuDetail setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
        return this;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public GoodSpuDetail setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public GoodSpuDetail setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "GoodSpuDetail{" +
                "spuId=" + spuId +
                ", subImg=" + subImg +
                ", detailDesc=" + detailDesc +
                ", collectNum=" + collectNum +
                ", delFlag=" + delFlag +
                "}";
    }
}
