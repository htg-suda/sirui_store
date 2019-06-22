package com.htg.good.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.dto.good.system.BrandDto;
import com.htg.common.entity.good.Brand;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.vo.good.BrandVo;
import com.htg.good.constant.BrandConst;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.exception.GlobalException;
import com.htg.good.mapper.BrandMapper;
import com.htg.good.service.IBrandCategoryService;
import com.htg.good.service.IBrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    private IBrandCategoryService brandCategoryService;

    /* 添加品牌 */
    @Override
    public CommonResult<RespId> addBrand(Brand brand) throws GlobalException {
        String nameCN = brand.getNameCn();
        String nameEN = brand.getNameEg();
        List<Brand> brandExistList = baseMapper.selectByName(nameCN, nameEN);
        if (brandExistList.size() != 0) {
            throw new GlobalException(CodeEnum.BRAND_HAS_EXISTS);
        }
        /* 默认设置品牌是审核不通过的 */
        brand.setVerify(BrandConst.VERIFY_ING);
        brand.setVerifyRemark(null);
        brand.setDelFlag(Del_FLAG.EXISTED);
        brand.setId(null);
        if (insert(brand)) {
            return CommonResult.success(new RespId(brand.getId()));
        } else {
            return CommonResult.error("添加失败");
        }
    }

    @Override
    public CommonResult<RespId> deleteBrand(Integer brandId) throws GlobalException {
        Integer categoryBrandCount = brandCategoryService.checkExistByCategoryBrand(null, brandId);
        if (categoryBrandCount != 0) {
            throw new GlobalException(CodeEnum.BRAND_IN_USER);
        }
        if (deleteById(brandId)) {
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.error("删除失败");
        }
    }

    @Override
    public CommonResult<RespList<BrandVo>> listAllBrand() {
        List<Brand> brandList = baseMapper.selectAll();
        List<BrandVo> list = new ArrayList<>();
        for (Brand brand : brandList) {
            BrandVo brandVo = new BrandVo();
            BeanUtils.copyProperties(brand, brandVo);
            list.add(brandVo);
        }
        return CommonResult.success(new RespList<>(list));
    }


    @Override
    public CommonResult modifyBrand(BrandDto brandDto) throws GlobalException {
        Brand brand = selectById(brandDto.getId());
        if (null == brand) {
            throw new GlobalException(CodeEnum.BRAND_NOT_EXIST);
        }

        if (!brand.getNameCn().equals(brandDto.getNameCn()) || !brand.getNameEg().equals(brandDto.getNameEg())) {
            throw new GlobalException(CodeEnum.BRAND_CAN_NOT_CHANGE_NAME);
        }
        BeanUtils.copyProperties(brandDto, brand);
        if (brand.getVerify() == BrandConst.VERIFY_PASS) {
            brand.setVerifyRemark(null);
        }
        if (updateAllColumnById(brand)) {
            return CommonResult.success("更新成功");
        } else {
            return CommonResult.success("更新失败");
        }
    }
}
