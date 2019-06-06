package com.htg.common.dto.good.shop;

import com.htg.common.entity.good.GoodSpu;
import com.htg.common.entity.good.GoodSpuDetail;
import com.htg.common.entity.good.SpuGoodSpecValue;

import java.util.List;

public class ShopAddGoodSpuDto {
    private GoodSpu spu;
    private GoodSpuDetail spuDetail;
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
