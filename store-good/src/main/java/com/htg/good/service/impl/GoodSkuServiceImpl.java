package com.htg.good.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.dto.good.shop.ShopAddGoodSkuDto;
import com.htg.common.dto.good.user.UserSkuQuery;
import com.htg.common.entity.good.*;
import com.htg.common.result.*;
import com.htg.common.vo.good.shop.ShopGoodSkuDetailVo;
import com.htg.common.vo.good.shop.ShopGoodSkuVo;
import com.htg.common.vo.good.shop.ShopSkuGoodSpecValueVo;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.vo.good.user.UserGoodSkuDetailVo;
import com.htg.common.vo.good.user.UserGoodSkuVo;
import com.htg.common.vo.good.user.UserQuerySkuVo;
import com.htg.common.vo.good.user.UserSkuGoodSpecValueVo;
import com.htg.good.constant.GoodSkuConst;
import com.htg.good.constant.GoodSpuConst;
import com.htg.common.exception.GlobalException;
import com.htg.good.mapper.GoodSkuMapper;
import com.htg.good.service.*;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 商品的sku 表,具体到某一款商品 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */

@Service
public class GoodSkuServiceImpl extends ServiceImpl<GoodSkuMapper, GoodSku> implements IGoodSkuService {
    @Autowired
    private IGoodSkuDetailService iGoodSkuDetailService;
    @Autowired
    private IGoodSpuService spuService;
    @Autowired
    private IGoodSkuStockService iGoodSkuStockService;
    @Autowired
    private ISkuGoodSpecValueService iSkuGoodSpecValueService;

    @Override
    @Transactional(rollbackFor = GlobalException.class)
    public CommonResult<RespId> addGoodSku(ShopAddGoodSkuDto goodSkuDto) throws GlobalException {
        /* 检查分类是否存在 , 检查spu 是否存在 , */
        GoodSku goodSku = goodSkuDto.getGoodSku();
        Integer spuId = goodSku.getSpuId();
        GoodSpu goodSpu = spuService.selectById(spuId);
        if (null == goodSpu) throw new GlobalException(CodeEnum.SPU_NOT_EXIST);
        if (goodSpu.getState() != GoodSpuConst.STATUS_ON_SALE)
            throw new GlobalException(CodeEnum.GOOD_SPU_STATE_NOT_ON_SALE);

        if (goodSpu.getVerify() != GoodSpuConst.VERIFY_PASS) throw new GlobalException(CodeEnum.GOOD_SPU_VERIFY_UNPASS);

        goodSku.setId(null);
        goodSku.setSkuNum(UUID.randomUUID().toString());
        goodSku.setCollectNum(0);
        goodSku.setDelFlag(Del_FLAG.EXISTED);
        goodSku.setStatus(GoodSkuConst.STATE_ACTIVE);
        if (!insert(goodSku)) throw new GlobalException(CodeEnum.ADD_GOOD_SKU_ERROR);

        Integer id = goodSku.getId();
        GoodSkuDetail skuDetail = goodSkuDto.getSkuDetail();
        skuDetail.setSkuId(id);
        skuDetail.setDelFlag(Del_FLAG.EXISTED);
        if (!iGoodSkuDetailService.insert(skuDetail)) throw new GlobalException(CodeEnum.ADD_GOOD_SKU_ERROR);

        GoodSkuStock skuStock = goodSkuDto.getSkuStock();
        skuStock.setDelFlag(Del_FLAG.EXISTED);
        skuStock.setSkuId(id);
        /* 设置库存报警值 */
        skuStock.setStockAlarm(0);
        if (!iGoodSkuStockService.insert(skuStock)) throw new GlobalException(CodeEnum.ADD_GOOD_SKU_ERROR);

        List<SkuGoodSpecValue> skuGoodSpecValueList = goodSkuDto.getSkuGoodSpecValueList();
        for (SkuGoodSpecValue skuGoodSpecValue : skuGoodSpecValueList) {
            skuGoodSpecValue.setId(null);
            skuGoodSpecValue.setSkuId(id);
            if (!iSkuGoodSpecValueService.insert(skuGoodSpecValue))
                throw new GlobalException(CodeEnum.ADD_GOOD_SKU_ERROR);
        }

        return CommonResult.success(new RespId(id));
    }

    /* 列出sku */
    @Override
    public CommonResult<RespList<ShopGoodSkuVo>> listBySpuId(Integer spuId) {
        List<GoodSku> goodSkuList = baseMapper.selectBySpuId(spuId);
        List<ShopGoodSkuVo> shopGoodSkuVoList = new ArrayList<>();
        for (GoodSku goodSku : goodSkuList) {
            ShopGoodSkuVo shopGoodSkuVo = new ShopGoodSkuVo();
            BeanUtils.copyProperties(goodSku, shopGoodSkuVo);
        }
        return CommonResult.success(new RespList<>(shopGoodSkuVoList));
    }

    /* 获取 sku 详细的详情 */
    @Override
    public CommonResult<ShopGoodSkuDetailVo> detailSku(Integer skuId) {
        GoodSku goodSku = selectById(skuId);
        ShopGoodSkuDetailVo detailVo = new ShopGoodSkuDetailVo();
        BeanUtils.copyProperties(goodSku, detailVo);

        /* 获取详情 */
        GoodSkuDetail goodSkuDetail = iGoodSkuDetailService.selectById(skuId);
        BeanUtils.copyProperties(goodSkuDetail, detailVo);


        /*获取库存信息*/
        GoodSkuStock goodSkuStock = iGoodSkuStockService.selectById(skuId);
        BeanUtils.copyProperties(goodSkuStock, detailVo);

        /* 获取规格数据 */
        List<SkuGoodSpecValue> specValueList = iSkuGoodSpecValueService.selectBySkuId(skuId);
        List<ShopSkuGoodSpecValueVo> valueVoList = new ArrayList<>();
        for (SkuGoodSpecValue skuGoodSpecValue : specValueList) {
            ShopSkuGoodSpecValueVo valueVo = new ShopSkuGoodSpecValueVo();
            BeanUtils.copyProperties(skuGoodSpecValue, valueVo);
            valueVoList.add(valueVo);
        }
        detailVo.setSpecValueList(valueVoList);
        return CommonResult.success(detailVo);
    }

    @Override
    public CommonResult<RespPage<UserQuerySkuVo>> listByQuery(UserSkuQuery userSkuQuery) {
        Integer pageSize = userSkuQuery.getPageSize();
        Integer pageNum = userSkuQuery.getPageNum();
        Page<UserQuerySkuVo> page = new Page<>(pageNum, pageSize);
        if (null != userSkuQuery.getKeyWord()) {
            String keyWord = userSkuQuery.getKeyWord();
            userSkuQuery.setKeyWord("%" + keyWord + "%");
        }
        List<UserQuerySkuVo> userQuerySkuVos = baseMapper.selectSkuBySpecList(page, userSkuQuery);
        return CommonResult.success(new RespPage<>(userQuerySkuVos, page.getTotal()));
    }

    @Override
    public CommonResult<UserGoodSkuVo> getUserSkuByNum(String skuNum) throws GlobalException {
        GoodSku goodSku = baseMapper.selectBySkuNum(skuNum);
        if (goodSku != null) {
            Integer spuId = goodSku.getSpuId();
            GoodSpu goodSpu = spuService.selectById(spuId);
            if (goodSpu.getState() != GoodSpuConst.VERIFY_PASS) {  // 如果已经审核通过了
                throw new GlobalException(CodeEnum.GOOD_SPU_VERIFY_UNPASS);
            } else {
                UserGoodSkuVo skuVo = new UserGoodSkuVo();
                BeanUtils.copyProperties(goodSku, skuVo);
                return CommonResult.success(skuVo);
            }
        } else {
            throw new GlobalException(CodeEnum.SKU_GOOD_NOT_EXIST);
        }
    }

    /* 列出 sku */
    @Override
    public CommonResult<UserGoodSkuDetailVo> getUserSkuDetail(String skuNum) throws GlobalException {
        GoodSku goodSku = baseMapper.selectBySkuNum(skuNum);
        UserGoodSkuDetailVo detailVo = new UserGoodSkuDetailVo();

        if (goodSku == null) throw new GlobalException(CodeEnum.SKU_GOOD_NOT_EXIST);
        Integer spuId = goodSku.getSpuId();
        GoodSpu goodSpu = spuService.selectById(spuId);
        if (goodSpu.getState() != GoodSpuConst.VERIFY_PASS) throw new GlobalException(CodeEnum.GOOD_SPU_VERIFY_UNPASS);
        BeanUtils.copyProperties(goodSku, detailVo);

        Integer skuId = goodSku.getId();
        /* 获取详情 */
        GoodSkuDetail goodSkuDetail = iGoodSkuDetailService.selectById(skuId);
        if (goodSkuDetail != null) {
            BeanUtils.copyProperties(goodSkuDetail, detailVo);
        }

        /*获取库存信息*/
        GoodSkuStock goodSkuStock = iGoodSkuStockService.selectById(skuId);
        if (goodSkuStock != null) {
            BeanUtils.copyProperties(goodSkuStock, detailVo);
        }

        /* 获取规格数据 */
        List<SkuGoodSpecValue> specValueList = iSkuGoodSpecValueService.selectBySkuId(skuId);
        List<UserSkuGoodSpecValueVo> valueVoList = new ArrayList<>();
        for (SkuGoodSpecValue skuGoodSpecValue : specValueList) {
            UserSkuGoodSpecValueVo valueVo = new UserSkuGoodSpecValueVo();
            BeanUtils.copyProperties(skuGoodSpecValue, valueVo);
            valueVoList.add(valueVo);
        }
        detailVo.setSpecValueList(valueVoList);

        return CommonResult.success(detailVo);
    }

}
