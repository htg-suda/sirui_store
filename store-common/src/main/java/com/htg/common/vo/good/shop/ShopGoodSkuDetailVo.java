package com.htg.common.vo.good.shop;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ShopGoodSkuDetailVo extends ShopGoodSkuVo {
    /**
     * 商品副图,一个json 数组的字符串 xxxx.png;xxxx.png
     */
    @ApiModelProperty(value = "商品副图,", example = "xxxx.png;xxxx.png")
    private String subImg;
    /**
     * 商品描述详情,是一段html富文本
     */
    @ApiModelProperty(value = "商品描述详情,是一段html富文本,", example = "<html>hello world</html>")
    private String detailDesc;

    /**
     * 商品的库存总量
     */
    @ApiModelProperty(value = "商品的库存总量", example = "9999")
    @TableField("stock")
    private Integer stock;
    /**
     * 库存警戒值
     */
    @ApiModelProperty(value = "库存警戒值", example = "66")
    @TableField("stock_alarm")
    private Integer stockAlarm;

    @ApiModelProperty(value = "规格参数表")
    private List<ShopSkuGoodSpecValueVo> specValueList;

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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStockAlarm() {
        return stockAlarm;
    }

    public void setStockAlarm(Integer stockAlarm) {
        this.stockAlarm = stockAlarm;
    }

    public List<ShopSkuGoodSpecValueVo> getSpecValueList() {
        return specValueList;
    }

    public void setSpecValueList(List<ShopSkuGoodSpecValueVo> specValueList) {
        this.specValueList = specValueList;
    }

    /**
     * 删除状态,0-有效,-1 -删除
     */
    @Override
    public String toString() {
        return "ShopGoodSkuDetailVo{" +
                "subImg='" + subImg + '\'' +
                ", detailDesc='" + detailDesc + '\'' +
                ", stock=" + stock +
                ", stockAlarm=" + stockAlarm +
                ", specValueList=" + specValueList +
                '}';
    }
}
