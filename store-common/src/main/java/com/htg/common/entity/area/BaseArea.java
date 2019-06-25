package com.htg.common.entity.area;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author htg
 * @since 2019-06-25
 */
@TableName("base_area")
public class BaseArea extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("codeid")
    private Integer codeid;
    @TableField("parentid")
    private Integer parentid;
    @TableField("cityName")
    private String cityName;


    public Integer getCodeid() {
        return codeid;
    }

    public BaseArea setCodeid(Integer codeid) {
        this.codeid = codeid;
        return this;
    }

    public Integer getParentid() {
        return parentid;
    }

    public BaseArea setParentid(Integer parentid) {
        this.parentid = parentid;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public BaseArea setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    @Override
    public String toString() {
        return "BaseArea{" +
        "codeid=" + codeid +
        ", parentid=" + parentid +
        ", cityName=" + cityName +
        "}";
    }
}
