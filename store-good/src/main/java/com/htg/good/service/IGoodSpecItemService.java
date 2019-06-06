package com.htg.good.service;

import com.htg.common.entity.good.GoodSpecItem;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.good.exception.GlobalException;

/**
 * <p>
 * 规格参数名表 服务类
 * </p>
 * @author htg
 * @since 2019-05-29
 */
public interface IGoodSpecItemService extends IService<GoodSpecItem> {

    CommonResult<RespId> addGoodSpecItem(GoodSpecItem goodSpecItem) throws GlobalException;

    CommonResult<RespList<GoodSpecItem>> listGoodSpecItem(Integer categoryId, Integer groupId);
}
