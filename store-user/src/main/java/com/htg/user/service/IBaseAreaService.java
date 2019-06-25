package com.htg.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.entity.area.BaseArea;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author htg
 * @since 2019-06-25
 */
public interface IBaseAreaService extends IService<BaseArea> {

    CommonResult<RespList<BaseArea>> getBaseAreaByParentId(Integer parentId);

    CommonResult<BaseArea> getBaseAreaByCodeId(Integer codeId);
}
