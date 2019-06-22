package com.htg.good.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.constant.SellerConst;
import com.htg.common.constant.StoreConst;
import com.htg.common.dto.good.shop.*;
import com.htg.common.dto.good.system.SysModifyGoodSpuStateDto;
import com.htg.common.dto.good.system.SysVerifyGoodSpuDto;
import com.htg.common.dto.good.user.UserGoodSpuListDto;
import com.htg.common.entity.good.*;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.utils.AuthUtil;
import com.htg.common.vo.good.shop.ShopGoodSpuDetailVo;
import com.htg.common.vo.good.shop.ShopGoodSpuVo;
import com.htg.common.vo.good.shop.ShopSpuGoodSpecValueVo;
import com.htg.common.vo.good.user.UserGoodSpuDetailVo;
import com.htg.common.vo.good.user.UserGoodSpuVo;
import com.htg.common.vo.good.user.UserSpuGoodSpecValueVo;
import com.htg.feign.client.SellerClient;
import com.htg.good.constant.BrandConst;
import com.htg.common.constant.Del_FLAG;
import com.htg.good.constant.GoodSpuConst;
import com.htg.common.exception.GlobalException;
import com.htg.good.mapper.GoodSpuMapper;
import com.htg.good.service.*;
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

    @Autowired
    private ISpuGoodSpecValueService iSpuGoodSpecValueService;

    @Autowired
    private SellerClient sellerClient;

    @Override
    @Transactional(rollbackFor = GlobalException.class)
    public CommonResult<RespId> addGoodSpu(ShopAddGoodSpuDto goodSpu) throws GlobalException {
        SellerInfo sellerInfo = checkSellerInfo(AuthUtil.getLoginUserId());
        SellerStore sellerStore = checkSellerStore(AuthUtil.getLoginUserId());

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


        GoodSpu spu = goodSpu.getSpu();
        spu.setId(null);
        spu.setDelFlag(Del_FLAG.EXISTED);
        spu.setPayNum(0);
        spu.setEvaluateNum(0);
        spu.setStoreId(sellerStore.getId());
        /* 商品在售 */
        spu.setState(GoodSpuConst.STATUS_WAIT_SALE);
        /* 商品待系统管理员审核*/
        spu.setVerify(GoodSpuConst.VERIFY_ING);
        if (!insert(spu)) throw new GlobalException(CodeEnum.ADD_GOOD_SPU_ERROR);
        /* 插入 规格参数值 */
        Integer spuId = spu.getId();
        List<SpuGoodSpecValue> specValueList = goodSpu.getSpecValueList();
        for (SpuGoodSpecValue spuGoodSpecValue : specValueList) {
            spuGoodSpecValue.setId(null);
            spuGoodSpecValue.setSpuId(spuId);
            if (!iSpuGoodSpecValueService.insert(spuGoodSpecValue))
                throw new GlobalException(CodeEnum.ADD_GOOD_SPU_ERROR);
        }
        /* 添加spu 详情*/
        GoodSpuDetail spuDetail = goodSpu.getSpuDetail();
        spuDetail.setSpuId(spuId);
        spuDetail.setCollectNum(0);  // 设置收藏数量为空
        spuDetail.setDelFlag(Del_FLAG.EXISTED);
        if (!goodSpuDetailService.insert(spuDetail)) throw new GlobalException(CodeEnum.ADD_GOOD_SPU_ERROR);
        return CommonResult.success(new RespId(spu.getId()));
    }

    /* 按照异常 回滚事务 */
    @Override
    @Transactional(rollbackFor = {GlobalException.class})
    public CommonResult<RespId> modify(ShopModifyGoodSpuDto goodSpuModifyDto) throws GlobalException {
        SellerInfo sellerInfo = checkSellerInfo(AuthUtil.getLoginUserId());
        SellerStore sellerStore = checkSellerStore(AuthUtil.getLoginUserId());

        GoodSpuModifyDto spuModify = goodSpuModifyDto.getSpuModify();
        GoodSpuDetailModifyDto spuDetailModify = goodSpuModifyDto.getSpuDetailModify();

        if (spuModify.getId() != spuDetailModify.getSpuId()) {
            throw new GlobalException(CodeEnum.SPU_ID_ERROR);
        }

        GoodSpu goodSpu = selectById(spuModify.getId());
        if (null == goodSpu) {
            throw new GlobalException(CodeEnum.SPU_NOT_EXIST);
        }

        if (goodSpu.getState() == GoodSpuConst.STATUS_FORBID) {
            return CommonResult.error("该商品已经禁止售卖,无法被修改");
        }

        if (goodSpu.getStoreId() != sellerStore.getId()) {  // 对用户进行的 store 进行测试 ,看能不能对应上商户的storeId
            return CommonResult.error("您正在尝试修改一个不属于自己的商品");
        }


        /** 如果商品之前是审核未通过的商品,那么 修改状态为待审核中,售卖状态为待售卖*/
        if (goodSpu.getVerify() == GoodSpuConst.VERIFY_UNPASS) {
            goodSpu.setVerify(GoodSpuConst.VERIFY_ING);
            spuModify.setState(GoodSpuConst.STATUS_WAIT_SALE);
            goodSpu.setVerifyRemark(null);
        } else {
            log.info("===>  good has verifying or pass");
        }


        BeanUtils.copyProperties(spuModify, goodSpu);
        if (!updateById(goodSpu)) throw new GlobalException(CodeEnum.Modify_GOOD_SPU_ERROR);
        /* 根据 spu_id 查找 spuDetail */
        GoodSpuDetail spuDetail = goodSpuDetailService.selectById(spuDetailModify.getSpuId());
        if (spuDetail == null) throw new GlobalException(CodeEnum.SPU_DETAIL_NOT_EXIST);

        BeanUtils.copyProperties(spuDetailModify, spuDetail);
        if (!goodSpuDetailService.updateById(spuDetail)) throw new GlobalException(CodeEnum.SPU_DETAIL_NOT_EXIST);

        /* 获取规格值*/
        /* todo 这里没有对 其进行数据吻合性校验 */
        List<SpuSpecModifyValueDto> modifyValueList = goodSpuModifyDto.getModifySpecValueList();
        for (SpuSpecModifyValueDto modifyValue : modifyValueList) {
            SpuGoodSpecValue spuGoodSpecValue = new SpuGoodSpecValue();
            BeanUtils.copyProperties(modifyValue, spuGoodSpecValue);
            if (!iSpuGoodSpecValueService.updateById(spuGoodSpecValue))
                throw new GlobalException(CodeEnum.Modify_GOOD_SPU_ERROR);
        }
        return CommonResult.success("修改成功");
    }

    /*商户管理端*/
    @Override
    public CommonResult<RespPage<ShopGoodSpuVo>> list(GoodSpuListDto dto, Integer storeId) throws GlobalException {
        Page<GoodSpu> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        String searchName = dto.getName();
        if (searchName != null) {
            searchName = "%" + searchName + "%";
            dto.setName(searchName);
        }

        List<GoodSpu> goodSpuList = baseMapper.selectByPage(page, dto.getName(), storeId, dto.getCategoryId(), dto.getBrandId());

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
    public CommonResult<ShopGoodSpuDetailVo> getSysGoodSpuDetailById(Integer spuId) throws GlobalException {
        GoodSpu spu = checkSpu(spuId);
        return getGoodSpuDetailBySpu(spu);
    }



    @Override
    public CommonResult<ShopGoodSpuDetailVo> getShopGoodSpuDetailById(Integer spuId) throws GlobalException {
        SellerInfo sellerInfo = checkSellerInfo(AuthUtil.getLoginUserId());
        SellerStore sellerStore = checkSellerStore(AuthUtil.getLoginUserId());
        GoodSpu spu = checkSpu(spuId);
        if (spu.getStoreId() != sellerStore.getId()) {
            return CommonResult.error("您正在尝试获取一个不属于您的商品");
        }
        return getGoodSpuDetailBySpu(spu);
    }

    private CommonResult<ShopGoodSpuDetailVo> getGoodSpuDetailBySpu(GoodSpu spu) throws GlobalException {

        GoodSpuDetail goodSpuDetail = checkSpuDetail(spu.getId());

        ShopGoodSpuDetailVo shopGoodSpuDetailVo = new ShopGoodSpuDetailVo();
        BeanUtils.copyProperties(spu, shopGoodSpuDetailVo);
        BeanUtils.copyProperties(goodSpuDetail, shopGoodSpuDetailVo);
        /* 遍历 copy 规格值 */
        List<SpuGoodSpecValue> specValueList = iSpuGoodSpecValueService.selectBySpuId(spu.getId());
        List<ShopSpuGoodSpecValueVo> shopSpecVoList = new ArrayList<>();
        for (SpuGoodSpecValue specValue : specValueList) {

            ShopSpuGoodSpecValueVo specValueVo = new ShopSpuGoodSpecValueVo();
            BeanUtils.copyProperties(specValue, specValueVo);
            shopSpecVoList.add(specValueVo);
        }

        shopGoodSpuDetailVo.setSpecValueVoList(shopSpecVoList);

        /* 设置 spu 的中英文名 */
        Integer brandId = spu.getBrandId();
        Brand brand = iBrandService.selectById(brandId);
        if (brand != null) {
            shopGoodSpuDetailVo.setBrandNameCN(brand.getNameCn());
            shopGoodSpuDetailVo.setBrandNameEG(brand.getNameEg());
        } else {
            log.info("brand error id is {}", brandId);
        }

        /* 设置spu商品分类名*/
        Integer categoryId = spu.getCategoryId();
        GoodCategory goodCategory = goodCategoryService.selectById(categoryId);
        if (goodCategory != null) {
            shopGoodSpuDetailVo.setCategoryName(goodCategory.getName());
        } else {
            log.info("category error id is {}", categoryId);
        }
        return CommonResult.success(shopGoodSpuDetailVo);
    }


    /* 用户端 展示商品spu */
    @Override
    public CommonResult<RespPage<UserGoodSpuVo>> list(UserGoodSpuListDto dto) {
        Page<GoodSpu> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        String searchName = dto.getName();
        if (searchName != null) {
            searchName = "%" + searchName + "%";
            dto.setName(searchName);
        }

        /*todo  这里是普通用户的列出商品, 由于现在没有商户 且由于只做邦德家的商品,所以前端要写死 categroyId 和 brand的 id , storeId */
        List<GoodSpu> goodSpuList = baseMapper.selectByPage(page, dto.getName(), dto.getStoreId(), dto.getCategoryId(), dto.getBrandId());

        List<UserGoodSpuVo> userGoodSpuVos = new ArrayList<>();

        for (GoodSpu spu : goodSpuList) {
            if (spu.getState() != GoodSpuConst.STATUS_ON_SALE || spu.getVerify() != GoodSpuConst.VERIFY_PASS) {  // 过滤掉状态不是在售卖的商品
                log.info("=====> spu state {}", spu.getState());
                continue;
            }
            Integer brandId = spu.getBrandId();
            Brand brand = iBrandService.selectById(brandId);
            Integer categoryId = spu.getCategoryId();
            GoodCategory goodCategory = goodCategoryService.selectById(categoryId);
            UserGoodSpuVo userGoodSpuVo = new UserGoodSpuVo();
            BeanUtils.copyProperties(spu, userGoodSpuVo);
            if (goodCategory != null) {
                userGoodSpuVo.setCategoryName(goodCategory.getName());
            } else {
                log.info("category err id is {}", categoryId);
            }

            if (brand != null) {
                userGoodSpuVo.setBrandNameCN(brand.getNameCn());
                userGoodSpuVo.setBrandNameEG(brand.getNameEg());
            } else {
                log.info("brand err id is {}", brandId);
            }
            userGoodSpuVos.add(userGoodSpuVo);
        }
        long pages = page.getPages();
        return CommonResult.success(new RespPage(userGoodSpuVos, pages));
    }


    @Override
    public CommonResult<UserGoodSpuDetailVo> getUserGoodSpuDetailById(Integer spuId) throws GlobalException {

        /* todo 检测商铺是否存在 且属于当前添加的用户*/
        GoodSpu spu = checkSpu(spuId);
        GoodSpuDetail goodSpuDetail = checkSpuDetail(spu.getId());


        UserGoodSpuDetailVo userGoodSpuDetailVo = new UserGoodSpuDetailVo();
        BeanUtils.copyProperties(spu, userGoodSpuDetailVo);
        BeanUtils.copyProperties(goodSpuDetail, userGoodSpuDetailVo);

        /* 根据 id 查找 */
        List<SpuGoodSpecValue> specValueList = iSpuGoodSpecValueService.selectBySpuId(spuId);
        List<UserSpuGoodSpecValueVo> userSpecVoList = new ArrayList<>();
        for (SpuGoodSpecValue specValue : specValueList) {
            UserSpuGoodSpecValueVo userSpecValue = new UserSpuGoodSpecValueVo();
            BeanUtils.copyProperties(specValue, userSpecValue);
            userSpecVoList.add(userSpecValue);
        }

        userGoodSpuDetailVo.setSpecValueVoList(userSpecVoList);
        /* 设置spu商品分类名*/
        Integer categoryId = spu.getCategoryId();
        GoodCategory goodCategory = goodCategoryService.selectById(categoryId);
        if (goodCategory != null) {
            userGoodSpuDetailVo.setCategoryName(goodCategory.getName());
        } else {
            log.info("category error id is {}", categoryId);
        }
        /* 设置 spu 的中英文名 */
        Integer brandId = spu.getBrandId();
        Brand brand = iBrandService.selectById(brandId);
        if (brand != null) {
            userGoodSpuDetailVo.setBrandNameCN(brand.getNameCn());
            userGoodSpuDetailVo.setBrandNameEG(brand.getNameEg());
        } else {
            log.info("brand error id is {}", brandId);
        }

        return CommonResult.success(userGoodSpuDetailVo);

    }

    /* 管理员修改 商品SPU 状态*/
    @Override
    public CommonResult<RespId> modify(SysModifyGoodSpuStateDto modifyStateDto) throws GlobalException {

        Integer spuId = modifyStateDto.getSpuId();
        GoodSpu goodSpu = selectById(spuId);
        if (goodSpu == null) {
            throw new GlobalException(CodeEnum.SPU_NOT_EXIST);
        }
        Integer modifyState = modifyStateDto.getState();
        /* 校验状态只能是 禁售或则 解禁 */
        if (modifyState != GoodSpuConst.STATUS_FORBID && modifyState != GoodSpuConst.STATUS_UN_FORBID) {
            throw new GlobalException(CodeEnum.Modify_GOOD_SPU_STATE_ERROR);
        }


        goodSpu.setState(modifyState);
        goodSpu.setStateRemark(modifyStateDto.getStateRemark());
        if (modifyState == GoodSpuConst.STATUS_UN_FORBID) { // 如果已经解禁了那么清除之前禁止售卖的原因
            goodSpu.setStateRemark("");
        }
        if (updateById(goodSpu)) {
            return CommonResult.success(new RespId(spuId));
        } else {
            return CommonResult.error("修改失败");
        }
    }

    /* 修改商品审核状态 */
    @Override
    public CommonResult<RespId> modify(SysVerifyGoodSpuDto verifyGoodSpuDto) throws GlobalException {
        Integer spuId = verifyGoodSpuDto.getSpuId();
        GoodSpu goodSpu = selectById(spuId);
        if (goodSpu == null) {
            throw new GlobalException(CodeEnum.SPU_NOT_EXIST);
        }

        Integer verify = verifyGoodSpuDto.getVerify();
        if (verify != GoodSpuConst.VERIFY_PASS && verify != GoodSpuConst.VERIFY_UNPASS) {
            throw new GlobalException(CodeEnum.Modify_GOOD_SPU_VERIFY_ERROR);
        }

        goodSpu.setVerify(verify);
        goodSpu.setStateRemark(verifyGoodSpuDto.getVerifyRemark());
        /* 如果审核通过 ,并且之前是待售卖的话,那么修改为在售*/
        if (goodSpu.getState() == GoodSpuConst.STATUS_WAIT_SALE && verify == GoodSpuConst.VERIFY_PASS) {
            goodSpu.setState(GoodSpuConst.STATUS_ON_SALE);
            goodSpu.setVerifyRemark("");
        }
        if (updateById(goodSpu)) {
            return CommonResult.success(new RespId(spuId));
        } else {
            return CommonResult.error("修改失败");
        }
    }


    public GoodSpu checkSpu(Integer spuId) throws GlobalException {
        GoodSpu spu = selectById(spuId);
        if (spu == null) {
            throw new GlobalException(CodeEnum.SPU_NOT_EXIST);
        }
        return spu;
    }

    public GoodSpuDetail checkSpuDetail(Integer spuId) throws GlobalException {
        GoodSpuDetail goodSpuDetail = goodSpuDetailService.selectById(spuId);
        if (goodSpuDetail == null) {
            throw new GlobalException(CodeEnum.SPU_ID_ERROR);
        }
        return goodSpuDetail;
    }


    @Override
    public SellerInfo checkSellerInfo(Integer userId) throws GlobalException {
        SellerInfo sellerInfo = sellerClient.getSellerInfoByUserId(userId);
        if (sellerInfo == null) throw new GlobalException(CodeEnum.YOU_ARE_NOT_SELLER); // 检查用户是否是商户
        if (sellerInfo.getState() != SellerConst.STATE_VERIFY_PASS)
            throw new GlobalException(CodeEnum.SELLER_STATE_ERROR); //状态是否已经审核通过
        return sellerInfo;
    }

    @Override
    public SellerStore checkSellerStore(Integer userId) throws GlobalException {
        SellerStore sellerStore = sellerClient.getSellerStoreByUserId(userId);
        if (sellerStore == null) throw new GlobalException(CodeEnum.SELLER_STORE_NOT_EXIST);  // 店铺是否已经存在
        if (sellerStore.getStatus() != StoreConst.STATUS_ACTIVE)
            throw new GlobalException(CodeEnum.SELLER_STORE_NOT_ACTIVE);
        return sellerStore;
    }

}
