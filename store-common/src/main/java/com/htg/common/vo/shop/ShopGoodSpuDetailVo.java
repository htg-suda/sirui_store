package com.htg.common.vo.shop;

import io.swagger.annotations.ApiModelProperty;

public class ShopGoodSpuDetailVo extends ShopGoodSpuVo {



    @ApiModelProperty(value = " 商品副图,字符串", example = " xxxx.png;xxxx.png")
    private String subImg;


    @ApiModelProperty(value = " 商品描述详情,是一段html富文本", example = "<html>hello world</html>", required = true)
    private String detailDesc;


    @ApiModelProperty(value = "商品收藏数量", example = "0", hidden = true)
    private Integer collectNum;


    public String getSubImg() {
        return subImg;
    }

    public void setSubImg(String subImg) {
        this.subImg = subImg;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }
}
