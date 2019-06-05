package com.htg.common.result;

public enum CodeEnum {
    SUCCESS(0, "操作成功"),
    ERROR(-1, "操作失败"),
    PARAM_ERROR(-1000, "参数异常"),
    TOKEN_ERROR(-1001, "Token异常"),
    PARENT_CATEGORY_NOT_EXISTS(-1002, "父分类不存在"),
    CATEGORY_HAS_EXISTS(-1003, "该分类已经存在"),
    BRAND_HAS_EXISTS(-1004, "品牌已经存在"),
    BRAND_HAS_IN_CATEGORY(-1006, "分类中已经存在该品牌"),
    CATEGORY_NOT_EXIST(-1007, "分类不存在"),
    BRAND_NOT_EXIST(-1008, "品牌不存在"),
    BRAND_IN_USER(-1009, "品牌使用中"),
    CATEGORY_IN_USER(-1010, "分类使用中"),
    BRAND_NOT_PASS(-1011, "品牌未审核通过"),
    BRAND_CAN_NOT_CHANGE_NAME(-1012, "品牌一旦添加将无法修改名字"),
    SPEC_GROUP_HAS_EXIST(-1013, "规格组已经存在"),
    SPEC_GROUP_NOT_EXIST(-1014, "规格组不存在"),
    SPEC_ITEM_CATEGORT_ERROR(-1015, "规格组分类异常"),
    SPEC_ITEM_HAS_EXIST(-1016, "规格参数已存在"),
    SPU_NOT_EXIST(-1017, "商品SPU不存在"),
    SPU_DETAIL_NOT_EXIST(-1018, "商品SPU DETAIL不存在"),
    SPU_ID_ERROR(-1019, "商品SPU ID 错误"),
    CATEGORY_BRAND_IS_ERROR(-1020, "品牌和分类不对应");

    private int code;
    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
