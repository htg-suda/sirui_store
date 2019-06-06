package com.htg.good.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.dto.good.system.GoodCategoryDto;
import com.htg.common.entity.good.Brand;
import com.htg.common.entity.good.BrandCategory;
import com.htg.common.entity.good.GoodCategory;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.vo.good.BrandVo;
import com.htg.common.vo.good.GoodCategoryVo;
import com.htg.good.constant.BrandConst;
import com.htg.good.constant.Del_FLAG;
import com.htg.good.exception.GlobalException;
import com.htg.good.mapper.GoodCategoryMapper;
import com.htg.good.service.IBrandCategoryService;
import com.htg.good.service.IBrandService;
import com.htg.good.service.IGoodCategoryService;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */

@Service
public class GoodCategoryServiceImpl extends ServiceImpl<GoodCategoryMapper, GoodCategory> implements IGoodCategoryService {
    @Autowired
    private IBrandCategoryService brandCategoryService;
    @Autowired
    private IBrandService brandService;

    @Override
    public CommonResult<RespList<GoodCategoryVo>> listChildCategory(Integer categoryId) {
        List<GoodCategory> goodCategories = baseMapper.selectByParentId(categoryId);
        List<GoodCategoryVo> goodCategoryVos = new ArrayList<>();
        for (GoodCategory goodCategory : goodCategories) {
            GoodCategoryVo categoryVo = new GoodCategoryVo();
            BeanUtils.copyProperties(goodCategory, categoryVo);
            goodCategoryVos.add(categoryVo);
        }

        return CommonResult.success(new RespList<>(goodCategoryVos));
    }


    @Override
    public CommonResult<RespList<BrandVo>> listBrandById(Integer categoryId) {
        List<BrandCategory> brandCategories = brandCategoryService.listByCategoryIdOrBrandId(categoryId, null);

        List<BrandVo> list = new ArrayList<>();
        for (BrandCategory brandCategory : brandCategories) {
            Brand brand = brandService.selectById(brandCategory.getBrandId());
            if (brand.getVerify() != BrandConst.VERIFY_PASS) {
                continue;
            }
            BrandVo brandVo = new BrandVo();
            BeanUtils.copyProperties(brand, brandVo);
            list.add(brandVo);
        }
        return CommonResult.success(new RespList<>(list));
    }


    @Override
    public CommonResult<RespId> addCategory(GoodCategory goodCategory) throws GlobalException {
        Integer parentId = goodCategory.getParentId();

        /** 检查父分类*/
        if (parentId != 0 && null != selectById(parentId)) {
            throw new GlobalException(CodeEnum.PARENT_CATEGORY_NOT_EXISTS);
        }
        /** 检查该分类下是否已经有了将要添加的分类*/
        String name = goodCategory.getName();
        Integer count = baseMapper.selectCountParentIdAnName(parentId, name);
        if (count > 0) {
            throw new GlobalException(CodeEnum.CATEGORY_HAS_EXISTS);
        }
        goodCategory.setId(null);
        goodCategory.setDelFlag(Del_FLAG.EXISTED);
        if (insert(goodCategory)) {
            return CommonResult.success(new RespId(goodCategory.getId()));
        } else {
            return CommonResult.error("添加失败");
        }
    }

    @Override
    public CommonResult modifyCategory(GoodCategoryDto goodCategoryDto) throws GlobalException {

        Integer parentId = goodCategoryDto.getParentId();
        /** 检查父分类*/
        if (parentId != 0 && null != selectById(parentId)) {
            throw new GlobalException(CodeEnum.PARENT_CATEGORY_NOT_EXISTS);
        }
        /*检查是否存在该分类id */
        GoodCategory goodCategory = selectById(goodCategoryDto.getId());
        if (goodCategory == null) {
            throw new GlobalException(CodeEnum.CATEGORY_NOT_EXIST);
        }

        /* 如果 更新了 父分类的id,或则是改了分类名 ,则要检查新父分类下是否已经存在 相同的分类名 */
        if (goodCategory.getParentId() != goodCategoryDto.getParentId() || !goodCategory.getName().equals(goodCategoryDto.getName())) {
            String name = goodCategoryDto.getName();
            Integer count = baseMapper.selectCountParentIdAnName(parentId, name);
            if (count > 0) {
                throw new GlobalException(CodeEnum.CATEGORY_HAS_EXISTS);
            }
        }


        BeanUtils.copyProperties(goodCategoryDto, goodCategory);
        if (updateAllColumnById(goodCategory)) {
            return CommonResult.success("更新成功");
        } else {
            return CommonResult.error("更新失败");
        }
    }

}
