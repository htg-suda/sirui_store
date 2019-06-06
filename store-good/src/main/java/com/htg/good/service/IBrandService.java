package com.htg.good.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.dto.good.system.BrandDto;
import com.htg.common.entity.good.Brand;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.vo.good.BrandVo;
import com.htg.good.exception.GlobalException;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface IBrandService extends IService<Brand> {

    CommonResult<RespId> addBrand(Brand brand) throws GlobalException;

    CommonResult<RespId> deleteBrand(Integer categoryId) throws GlobalException;

    CommonResult<RespList<BrandVo>> listAllBrand();

    CommonResult modifyBrand(BrandDto brandDto) throws GlobalException;
}
