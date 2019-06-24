package com.htg.common.constant;

/*
* 店铺状态 0-未开店 " +
            "1,商铺信息已经提交,待审核," +
            "2,已经提交商户信息,但是未审核通过," +
            "3,商户信息提交,且已经审核通过,未开店铺" +
            "4,商户信息提交,已经审核通过,且店铺已经激活"+
            "5,商户信息提交,已经审核通过,但是店铺冻结"+
            *6,商户被冻结
            *

* */
public class ShopConst {
    public static final Integer STATE_HAS_NO_SELLER_INFO=0;
    public static final Integer STATE_WAIT_VERIFY=1;
    public static final Integer STATE_VERIFY_UNPASS=2;
    public static final Integer STATE_VERIFY_PASS_NO_STORE=3;
    public static final Integer STATE_VERIFY_PASS_HAS_STOER_ACTIVE =4;
    public static final Integer STATE_VERIFY_PASS_HAS_STOER_FROZEN =5;

    public static final Integer STATE_SELLER_FROZEN =6;



}
