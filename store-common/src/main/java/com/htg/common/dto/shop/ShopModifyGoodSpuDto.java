package com.htg.common.dto.shop;

public class ShopModifyGoodSpuDto {
    private GoodSpuModifyDto spuModify;
    private GoodSpuDetailModifyDto spuDetailModify;

    public GoodSpuModifyDto getSpuModify() {
        return spuModify;
    }

    public void setSpuModify(GoodSpuModifyDto spuModify) {
        this.spuModify = spuModify;
    }

    public GoodSpuDetailModifyDto getSpuDetailModify() {
        return spuDetailModify;
    }

    public void setSpuDetailModify(GoodSpuDetailModifyDto spuDetailModify) {
        this.spuDetailModify = spuDetailModify;
    }
}
