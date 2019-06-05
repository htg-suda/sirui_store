package com.htg.good.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.dto.shop.*;
import com.htg.common.entity.Brand;
import com.htg.common.entity.GoodCategory;
import com.htg.common.entity.GoodSpu;
import com.htg.common.entity.GoodSpuDetail;
import com.htg.common.result.*;
import com.htg.common.vo.shop.ShopGoodSpuDetailVo;
import com.htg.common.vo.shop.ShopGoodSpuVo;
import com.htg.good.constant.BrandConst;
import com.htg.good.constant.Del_FLAG;
import com.htg.good.constant.GoodSkuConst;
import com.htg.good.exception.GlobalException;
import com.htg.good.mapper.GoodSpuMapper;
import com.htg.good.service.*;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品spu表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */

@Slf4j
@Service
public class GoodSpuServiceImpl extends ServiceImpl<GoodSpuMapper, GoodSpu> implements IGoodSpuService {
    @Autowired
    private IGoodSpuDetailService goodSpuDetailService;

    @Autowired
    private IBrandService iBrandService;

    @Autowired
    private IGoodCategoryService goodCategoryService;


    @Autowired
    private IBrandCategoryService brandCategoryService;

    @Override
    @Transactional
    public CommonResult<RespId> addGoodSpu(ShopAddGoodSpuDto goodSpu) throws GlobalException {
        GoodCategory goodCategory = goodCategoryService.selectById(goodSpu.getSpu().getCategoryId());
        if (goodCategory == null) {
            throw new GlobalException(CodeEnum.CATEGORY_NOT_EXIST);
        }

        Brand brand = iBrandService.selectById(goodSpu.getSpu().getBrandId());
        if (brand == null || brand.getVerify() != BrandConst.VERIFY_PASS) {
            throw new GlobalException(CodeEnum.BRAND_NOT_EXIST);
        }


        Integer count = brandCategoryService.checkExistByCategoryBrand(goodCategory.getId(), brand.getId());
        if (count <= 0) {
            throw new GlobalException(CodeEnum.CATEGORY_BRAND_IS_ERROR);
        }


        /* todo 检测商铺是否存在 且属于当前添加的用户*/


        GoodSpu spu = goodSpu.getSpu();
        spu.setId(null);
        spu.setDelFlag(Del_FLAG.EXISTED);
        spu.setPayNum(0);
        spu.setEvaluateNum(0);
        /* 商品在售 */
        spu.setState(GoodSkuConst.STATUS_ON_SALE);
        /* 商品待系统管理员审核*/
        spu.setVerify(GoodSkuConst.VERIFY_ING);
        if (insert(spu)) {
            Integer id = spu.getId();
            GoodSpuDetail spuDetail = goodSpu.getSpuDetail();
            spuDetail.setSpuId(id);
            spuDetail.setCollectNum(0);  // 设置收藏数量为空
            spuDetail.setDelFlag(Del_FLAG.EXISTED);
            if (goodSpuDetailService.insert(spuDetail)) {
                return CommonResult.success("添加成功");
            } else {
                return CommonResult.error("添加失败");
            }
        } else {
            return CommonResult.error("添加失败");
        }
    }

    /* 按照异常 回滚事务 */
    @Override
    @Transactional(rollbackFor = {GlobalException.class})
    public CommonResult<RespId> modify(ShopModifyGoodSpuDto goodSpuModifyDto) throws GlobalException {
        GoodSpuModifyDto spuModify = goodSpuModifyDto.getSpuModify();
        GoodSpuDetailModifyDto spuDetailModify = goodSpuModifyDto.getSpuDetailModify();

        if (spuModify.getId() != spuDetailModify.getSpuId()) {
            throw new GlobalException(CodeEnum.SPU_ID_ERROR);
        }

        GoodSpu goodSpu = selectById(spuModify.getId());
        if (null == goodSpu) {
            throw new GlobalException(CodeEnum.SPU_NOT_EXIST);
        }

        if (goodSpu.getState() == GoodSkuConst.STATUS_FORBID) {
            return CommonResult.error("该商品已经禁止售卖,无法被修改");
        }

        /*todo 对商品 进行验证 是否属于该 用户,是否属于该店面  */

        /** 如果商品之前是审核未通过的商品,那么 修改状态为待审核中*/
        if (goodSpu.getState() == GoodSkuConst.VERIFY_UNPASS) {
            goodSpu.setVerify(GoodSkuConst.VERIFY_ING);
            goodSpu.setVerifyRemark(null);
        }

        BeanUtils.copyProperties(spuModify, goodSpu);
        if (updateById(goodSpu)) {
            /* 根据 spu_id 查找 spuDetail */
            GoodSpuDetail spuDetail = goodSpuDetailService.selectById(spuDetailModify.getSpuId());
            if (spuDetail == null) {
                throw new GlobalException(CodeEnum.SPU_DETAIL_NOT_EXIST);
            }
            BeanUtils.copyProperties(spuDetailModify, spuDetail);
            if (goodSpuDetailService.updateById(spuDetail)) return CommonResult.success("修改成功");
        }
        return CommonResult.error("修改失败");
    }

    @Override
    public CommonResult<RespPage<ShopGoodSpuVo>> list(GoodSpuListDto dto) {
        Page<GoodSpu> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        String searchName = dto.getName();
        if (searchName != null) {
            searchName = "%" + searchName + "%";
            dto.setName(searchName);
        }
        /* todo 这里是商家端 的列出商品 ,需要传入商家的 store id */

        List<GoodSpu> goodSpuList = baseMapper.selectByPage(page, dto.getName(), null, dto.getCategoryId(), dto.getBrandId());

        List<ShopGoodSpuVo> shopGoodSpuVoList = new ArrayList<>();

        for (GoodSpu spu : goodSpuList) {
            Integer brandId = spu.getBrandId();
            Brand brand = iBrandService.selectById(brandId);
            Integer categoryId = spu.getCategoryId();
            GoodCategory goodCategory = goodCategoryService.selectById(categoryId);
            ShopGoodSpuVo shopGoodSpuVo = new ShopGoodSpuVo();
            BeanUtils.copyProperties(spu, shopGoodSpuVo);
            if (brand != null) {
                shopGoodSpuVo.setBrandNameCN(brand.getNameCn());
                shopGoodSpuVo.setBrandNameEG(brand.getNameEg());
            } else {
                log.info("brand err id is {}", brandId);
            }

            if (goodCategory != null) {
                shopGoodSpuVo.setCategoryName(goodCategory.getName());
            } else {
                log.info("category err id is {}", categoryId);
            }
            shopGoodSpuVoList.add(shopGoodSpuVo);
        }
        long pages = page.getPages();
        return CommonResult.success(new RespPage(shopGoodSpuVoList, pages));
    }

    @Override
    public CommonResult<ShopGoodSpuDetailVo> getShopGoodSpuDetailById(Integer spuId) throws GlobalException {

        GoodSpu spu = selectById(spuId);
        if (spu == null) {
            throw new GlobalException(CodeEnum.SPU_NOT_EXIST);
        }

        GoodSpuDetail goodSpuDetail = goodSpuDetailService.selectById(spu.getId());
        if (goodSpuDetail == null) {
            throw new GlobalException(CodeEnum.SPU_ID_ERROR);
        }

        Integer brandId = spu.getBrandId();
        Brand brand = iBrandService.selectById(brandId);
        Integer categoryId = spu.getCategoryId();
        GoodCategory goodCategory = goodCategoryService.selectById(categoryId);


        ShopGoodSpuDetailVo shopGoodSpuDetailVo = new ShopGoodSpuDetailVo();
        BeanUtils.copyProperties(spu, shopGoodSpuDetailVo);
        BeanUtils.copyProperties(goodSpuDetail, shopGoodSpuDetailVo);

        /* 设置 spu 的中英文名 */
        if (brand != null) {
            shopGoodSpuDetailVo.setBrandNameCN(brand.getNameCn());
            shopGoodSpuDetailVo.setBrandNameEG(brand.getNameEg());
        } else {
            log.info("brand error id is {}", brandId);
        }

        /* 设置spu商品分类名*/
        if (goodCategory != null) {
            shopGoodSpuDetailVo.setCategoryName(goodCategory.getName());
        } else {
            log.info("category error id is {}", categoryId);
        }

        return CommonResult.success(shopGoodSpuDetailVo);

    }
}
