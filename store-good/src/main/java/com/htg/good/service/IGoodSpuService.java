package com.htg.good.service;

import com.htg.common.dto.shop.GoodSpuListDto;
import com.htg.common.dto.shop.ShopAddGoodSpuDto;
import com.htg.common.dto.shop.ShopModifyGoodSpuDto;
import com.htg.common.entity.GoodSpu;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.vo.shop.ShopGoodSpuDetailVo;
import com.htg.common.vo.shop.ShopGoodSpuVo;
import com.htg.good.exception.GlobalException;

/**
 * <p>
 * 商品spu表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface IGoodSpuService extends IService<GoodSpu> {

    CommonResult<RespId> addGoodSpu(ShopAddGoodSpuDto goodSpu) throws GlobalException;


    CommonResult<RespId> modify(ShopModifyGoodSpuDto goodSpuModifyDto) throws GlobalException;

    CommonResult<RespPage<ShopGoodSpuVo>> list(GoodSpuListDto goodSpuListDto);

    CommonResult<ShopGoodSpuDetailVo> getShopGoodSpuDetailById(Integer spuId) throws GlobalException;
}
