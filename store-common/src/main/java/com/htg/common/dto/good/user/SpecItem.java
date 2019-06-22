package com.htg.common.dto.good.user;

import io.swagger.annotations.ApiModelProperty;

public class SpecItem {
    @ApiModelProperty(value = "规格参数名", example = "产品类型")
    private String name;
    @ApiModelProperty(value = "规格参数值", example = "工位")
    private String value;
    @ApiModelProperty(value = "符号 = > < ", example = "=")
    private String symbol;


    public SpecItem(String name, String value, String symbol) {
        this.name = name;
        this.value = value;
        this.symbol = symbol;
    }

    public SpecItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
