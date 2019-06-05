package com.htg.good.constant;

public class GoodSkuConst {

    /*0-下架(商家行为)*/
    public static final int STATUS_WITHDRAW = 0;

    /* 1-商家 在售*/
    public static final int STATUS_ON_SALE = 1;

    /*10-违规被禁止售卖(管理员行为),一旦禁止售卖则无法上架*/
    public static final int STATUS_FORBID = 10;


    /*商品审核未通过*/
    public static final int VERIFY_UNPASS = 0;

    /*商品审核通过 */
    public static final int VERIFY_PASS = 1;

    /*商品审核中*/
    public static final int VERIFY_ING = 10;


}
