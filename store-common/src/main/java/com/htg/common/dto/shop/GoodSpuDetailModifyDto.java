package com.htg.common.dto.shop;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商品spu详情表
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public class GoodSpuDetailModifyDto extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @NotNull(message = "商品spu id,不能为空")
    @ApiModelProperty(value = "商品spu id", example = "1",  dataType = "int", required = true)
    private Integer spuId;

    @ApiModelProperty(value = " 商品副图,字符串", example = " xxxx.png;xxxx.png")
    private String subImg;


    @NotBlank(message = "商品详情不能为空")
    @ApiModelProperty(value = " 商品描述详情,是一段html富文本", example = "<html>hello world</html>", required = true)
    private String detailDesc;

    public Integer getSpuId() {
        return spuId;
    }

    public GoodSpuDetailModifyDto setSpuId(Integer spuId) {
        this.spuId = spuId;
        return this;
    }

    public String getSubImg() {
        return subImg;
    }

    public GoodSpuDetailModifyDto setSubImg(String subImg) {
        this.subImg = subImg;
        return this;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public GoodSpuDetailModifyDto setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
        return this;
    }
}
