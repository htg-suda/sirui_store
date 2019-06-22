package com.htg.common.dto.good.shop;

import com.htg.common.entity.good.GoodSpu;
import com.htg.common.entity.good.GoodSpuDetail;
import com.htg.common.entity.good.SpuGoodSpecValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ShopAddGoodSpuDto {
    @NotNull(message = "spu 基本信息不能为空")
    @Valid
    private GoodSpu spu;

    @NotNull(message = "spu 详情不能为空")
    @Valid
    private GoodSpuDetail spuDetail;

    @NotNull(message = "spu 规格参数值不能为空")
    @Valid
    private List<SpuGoodSpecValue> specValueList;

    public GoodSpu getSpu() {
        return spu;
    }

    public void setSpu(GoodSpu spu) {
        this.spu = spu;
    }

    public GoodSpuDetail getSpuDetail() {
        return spuDetail;
    }

    public void setSpuDetail(GoodSpuDetail spuDetail) {
        this.spuDetail = spuDetail;
    }


    public List<SpuGoodSpecValue> getSpecValueList() {
        return specValueList;
    }

    public void setSpecValueList(List<SpuGoodSpecValue> specValueList) {
        this.specValueList = specValueList;
    }

    @Override
    public String toString() {
        return "ShopAddGoodSpuDto{" +
                "spu=" + spu +
                ", spuDetail=" + spuDetail +
                ", specValueList=" + specValueList +
                '}';
    }
}
