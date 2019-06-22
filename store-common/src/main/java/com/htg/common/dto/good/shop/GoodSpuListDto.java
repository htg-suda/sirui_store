package com.htg.common.dto.good.shop;

import javax.validation.constraints.NotNull;

public class GoodSpuListDto {
    @NotNull
    private Integer pageSize;
    @NotNull
    private Integer pageNum;

    private Integer categoryId;

    private Integer brandId;

    private String name;



    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "GoodSpuListDto{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", name='" + name + '\'' +
                '}';
    }
}
