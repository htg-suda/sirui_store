package com.htg.good.service;

import com.htg.common.dto.good.shop.GoodSpuListDto;
import com.htg.common.dto.good.shop.ShopAddGoodSpuDto;
import com.htg.common.dto.good.shop.ShopModifyGoodSpuDto;
import com.htg.common.dto.good.system.SysModifyGoodSpuStateDto;
import com.htg.common.dto.good.system.SysVerifyGoodSpuDto;
import com.htg.common.dto.good.user.UserGoodSpuListDto;
import com.htg.common.entity.good.GoodSpu;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.vo.good.shop.ShopGoodSpuDetailVo;
import com.htg.common.vo.good.shop.ShopGoodSpuVo;
import com.htg.common.vo.good.user.UserGoodSpuDetailVo;
import com.htg.common.vo.good.user.UserGoodSpuVo;
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

    CommonResult<RespPage<UserGoodSpuVo>> list(UserGoodSpuListDto goodSpuListDto);

    CommonResult<UserGoodSpuDetailVo> getUserGoodSpuDetailById(Integer spuId) throws GlobalException;

    CommonResult<RespId> modify(SysModifyGoodSpuStateDto modifyState) throws GlobalException;

    CommonResult<RespId> modify(SysVerifyGoodSpuDto verifyGoodSpuDto) throws GlobalException;
}
