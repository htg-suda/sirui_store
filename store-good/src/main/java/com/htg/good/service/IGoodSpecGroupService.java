package com.htg.good.service;

import com.htg.common.entity.GoodSpecGroup;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.good.exception.GlobalException;

/**
 * <p>
 * 规格组表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface IGoodSpecGroupService extends IService<GoodSpecGroup> {

    CommonResult<RespId> addSpecGroup(GoodSpecGroup goodSpecGroup) throws GlobalException;

    CommonResult<RespList<GoodSpecGroup>> listByCategoryId(Integer categoryId) throws GlobalException;
}
