package com.htg.good.service.impl;

import com.htg.common.entity.Brand;
import com.htg.common.entity.BrandCategory;
import com.htg.common.entity.GoodCategory;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.good.constant.BrandConst;
import com.htg.good.constant.Del_FLAG;
import com.htg.good.exception.GlobalException;
import com.htg.good.mapper.BrandCategoryMapper;
import com.htg.good.service.IBrandCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.good.service.IBrandService;
import com.htg.good.service.IGoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌和分类的关系表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Service
public class BrandCategoryServiceImpl extends ServiceImpl<BrandCategoryMapper, BrandCategory> implements IBrandCategoryService {
    @Autowired
    private IBrandService brandService;
    @Autowired
    private IGoodCategoryService goodCategoryService;

    /*  检查 该分类下是否已经存在 该品牌  */
    @Override
    public Integer checkExistByCategoryBrand(BrandCategory brandCategory) {
        Integer brandId = brandCategory.getBrandId();
        Integer categoryId = brandCategory.getCategoryId();
        Integer count = baseMapper.checkNumByCategoryBrand(categoryId, brandId);
        return count;
    }


    /*  检查 该分类下是否已经存在 该品牌  */
    @Override
    public Integer checkExistByCategoryBrand(Integer categoryId, Integer brandId) {
        Integer count = baseMapper.checkNumByCategoryBrand(categoryId, brandId);
        return count;
    }

    /* 根据 catgoryId 或则 brandId 来查找 */
    @Override
    public List<BrandCategory> listByCategoryIdOrBrandId(Integer categoryId, Integer brandId) {
        return baseMapper.selectbyCategoryIdOrBrandId(categoryId, brandId);
    }

    @Override
    public CommonResult<RespId> addBrandCategory(BrandCategory brandCategory) throws GlobalException {
        /* 检查分类是存在 */
        GoodCategory goodCategory = goodCategoryService.selectById(brandCategory.getCategoryId());
        if (goodCategory == null) {
            throw new GlobalException(CodeEnum.CATEGORY_NOT_EXIST);
        }
        /* 检查 品牌是否存在*/
        Brand brand = brandService.selectById(brandCategory.getBrandId());
        if (brand == null) {
            throw new GlobalException(CodeEnum.BRAND_NOT_EXIST);
        }

        if (brand.getVerify() != BrandConst.VERIFY_PASS) {
            throw new GlobalException(CodeEnum.BRAND_NOT_PASS);
        }
        /* 防止重复添加 */
        if (checkExistByCategoryBrand(brandCategory) > 0) {
            throw new GlobalException(CodeEnum.BRAND_HAS_IN_CATEGORY);
        }
        brandCategory.setDelFlag(Del_FLAG.EXISTED);
        brandCategory.setId(null);
        if (insert(brandCategory)) {
            return CommonResult.success(new RespId(brandCategory.getId()));
        } else {
            return CommonResult.error("添加失败");
        }
    }

    /* 解除关联 */


}
