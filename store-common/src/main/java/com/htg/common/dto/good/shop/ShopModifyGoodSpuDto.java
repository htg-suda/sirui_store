package com.htg.common.dto.good.shop;

import java.util.List;

public class ShopModifyGoodSpuDto {
    private GoodSpuModifyDto spuModify;
    private GoodSpuDetailModifyDto spuDetailModify;
    private List<SpuSpecModifyValueDto> modifySpecValueList;

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

    public List<SpuSpecModifyValueDto> getModifySpecValueList() {
        return modifySpecValueList;
    }

    public void setModifySpecValueList(List<SpuSpecModifyValueDto> modifySpecValueList) {
        this.modifySpecValueList = modifySpecValueList;
    }
}
