package com.htg.common.constant;

public class SellerConst {
    //0-待审核,1-审核通过已激活,-1 申请未通过 ,10-商户冻结
    public static final int STATE_WAIT_FOR_VERIFY = 0;
    public static final int STATE_VERIFY_PASS = 1;
    public static final int STATE_VERIFY_UNPASS = 2;
    public static final int STATE_FROZEN = 10;


    /*企业*/
    public static final int TYPE_ENTERPRISE = 0;
    /* 个人 */
    public static final int TYPE_INDIVIDUALS = 1;
}
