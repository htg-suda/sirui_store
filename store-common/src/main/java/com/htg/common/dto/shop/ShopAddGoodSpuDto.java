package com.htg.common.dto.shop;

import com.htg.common.entity.GoodSpu;
import com.htg.common.entity.GoodSpuDetail;

public class ShopAddGoodSpuDto {
    private GoodSpu spu;
    private GoodSpuDetail spuDetail;


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

    @Override
    public String toString() {
        return "ShopAddGoodSpuDto{" +
                "spu=" + spu +
                ", spuDetail=" + spuDetail +
                '}';
    }
}
