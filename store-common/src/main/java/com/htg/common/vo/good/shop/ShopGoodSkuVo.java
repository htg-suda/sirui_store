package com.htg.common.vo.good.shop;

import com.baomidou.mybatisplus.annotations.TableField;
import com.htg.common.vo.good.base.GoodSkuVo;
import io.swagger.annotations.ApiModelProperty;

public class ShopGoodSkuVo extends GoodSkuVo {

    /**
     * 0- 商品有效,-1 商品无效
     */
    @ApiModelProperty(value = "商品状态, 0- 商品有效,-1 商品无效", hidden = true)
    @TableField("status")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShopGoodSkuVo{" +
                "status=" + status +
                '}';
    }
}
