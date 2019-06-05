package com.htg.good.service;

import com.htg.common.entity.BrandCategory;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.good.exception.GlobalException;

import java.util.List;

/**
 * <p>
 * 品牌和分类的关系表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface IBrandCategoryService extends IService<BrandCategory> {


    Integer checkExistByCategoryBrand(BrandCategory brandCategory);


    Integer checkExistByCategoryBrand(Integer categoryId, Integer brandId);

    List<BrandCategory> listByCategoryIdOrBrandId(Integer categoryId, Integer brandId);

    CommonResult<RespId> addBrandCategory(BrandCategory brandCategory) throws GlobalException;
}
