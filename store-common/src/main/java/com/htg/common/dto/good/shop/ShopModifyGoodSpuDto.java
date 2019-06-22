package com.htg.common.dto.good.shop;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ShopModifyGoodSpuDto {
    @NotNull(message = "spu 基本信息能为空")
    @Valid
    private GoodSpuModifyDto spuModify;

    @NotNull(message = "spu 详情不能为空")
    @Valid
    private GoodSpuDetailModifyDto spuDetailModify;

    @NotNull(message = "spu 规格参数值不能为空")
    @Valid
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
