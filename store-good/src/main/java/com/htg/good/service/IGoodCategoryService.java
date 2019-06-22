package com.htg.good.service;

import com.htg.common.dto.good.system.GoodCategoryDto;
import com.htg.common.entity.good.GoodCategory;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.vo.good.BrandVo;
import com.htg.common.vo.good.GoodCategoryVo;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;

/**
 * <p>
 * 商品分类表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface IGoodCategoryService extends IService<GoodCategory> {
     /*根据id 选择分类*/
     CommonResult<RespList<GoodCategoryVo>> listChildCategory(Integer parentId);

     CommonResult<RespList<BrandVo>> listBrandById(Integer parentId);

     CommonResult<RespId> addCategory(GoodCategory goodCategory) throws GlobalException;

     CommonResult modifyCategory(GoodCategoryDto goodCategoryDto) throws GlobalException;
}
