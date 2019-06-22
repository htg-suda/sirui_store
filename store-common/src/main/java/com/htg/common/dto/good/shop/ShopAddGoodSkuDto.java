package com.htg.common.dto.good.shop;
import com.htg.common.entity.good.GoodSku;
import com.htg.common.entity.good.GoodSkuDetail;
import com.htg.common.entity.good.GoodSkuStock;
import com.htg.common.entity.good.SkuGoodSpecValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ShopAddGoodSkuDto {
    /* SKU 的 基本信息 */
    @NotNull(message = "sku基本信息不能为空")
    @Valid
    private GoodSku goodSku;

    /* SKU 的详细信息*/
    @NotNull(message = "SKU 的详细信息 基本不能为空")
    @Valid
    private GoodSkuDetail skuDetail;
    /* SKU 的库存信息*/
    @NotNull(message = "SKU 的库存信息 基本不能为空")
    @Valid
    private GoodSkuStock skuStock;
    /*SKU 规格值 */
    private List<SkuGoodSpecValue> skuGoodSpecValueList;


    public GoodSku getGoodSku() {
        return goodSku;
    }

    public void setGoodSku(GoodSku goodSku) {
        this.goodSku = goodSku;
    }

    public GoodSkuDetail getSkuDetail() {
        return skuDetail;
    }

    public void setSkuDetail(GoodSkuDetail skuDetail) {
        this.skuDetail = skuDetail;
    }

    public GoodSkuStock getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(GoodSkuStock skuStock) {
        this.skuStock = skuStock;
    }

    public List<SkuGoodSpecValue> getSkuGoodSpecValueList() {
        return skuGoodSpecValueList;
    }

    public void setSkuGoodSpecValueList(List<SkuGoodSpecValue> skuGoodSpecValueList) {
        this.skuGoodSpecValueList = skuGoodSpecValueList;
    }
}
