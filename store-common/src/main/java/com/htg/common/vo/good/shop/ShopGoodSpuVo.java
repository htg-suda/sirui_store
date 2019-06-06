package com.htg.common.vo.good.shop;

import com.htg.common.vo.good.base.GoodSpuVo;
import io.swagger.annotations.ApiModelProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopGoodSpuVo extends GoodSpuVo {

    @ApiModelProperty(value = "商品状态: 0-下架(商家行为), 1-在售,10-违规被禁止售卖(管理员行为),一旦禁止售卖则无法上架")
    private Integer state;


    @ApiModelProperty(value = "违规原因", example = "该商品不合法.")
    private String stateRemark;


    @ApiModelProperty(value = "商品审核 1-通过，0-未通过，10-审核中")
    private Integer verify;


    @ApiModelProperty(value = "审核不通过原因", example = "该商品不合法,不能上架...")
    private String verifyRemark;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateRemark() {
        return stateRemark;
    }

    public void setStateRemark(String stateRemark) {
        this.stateRemark = stateRemark;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public String getVerifyRemark() {
        return verifyRemark;
    }

    public void setVerifyRemark(String verifyRemark) {
        this.verifyRemark = verifyRemark;
    }
}
