package com.htg.common.dto.good.user;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserSkuQuery {
    @ApiModelProperty(value = "搜索关键字", example = "陆家嘴")
    private String keyWord;

    @ApiModelProperty(value = "规格列表")
    private List<SpecItem> specItems;

    @ApiModelProperty(value = "当前页", example = "1")
    private Integer pageNum;
    @ApiModelProperty(value = "每页长度", example = "5")
    private Integer pageSize;

    @Override
    public String toString() {
        return "UserSkuQuery{" +
                "keyWord='" + keyWord + '\'' +
                ", specItems=" + specItems +
                '}';
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<SpecItem> getSpecItems() {
        return specItems;
    }

    public void setSpecItems(List<SpecItem> specItems) {
        this.specItems = specItems;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
