package com.htg.seller.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.dto.seller.shop.SellerAddDto;
import com.htg.common.dto.seller.system.SellerListDto;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.vo.good.shop.ShopGoodSpuVo;
import com.htg.common.vo.seller.system.SysSellerListItem;

/**
 * <p>
 * 卖家/商户信息表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
public interface ISellerInfoService extends IService<SellerInfo> {

    CommonResult<RespId> addSeller(SellerAddDto sellerAddDto) throws GlobalException;

    CommonResult<RespId> addStore(SellerStore sellerStore) throws GlobalException;

    CommonResult<RespPage<SysSellerListItem>> getSellerList(SellerListDto listDto);

    CommonResult<RespPage<ShopGoodSpuVo>> getStoreSpuInfo(Integer pageSize, Integer pageNum) throws GlobalException;

    SellerInfo getSellerInfo(Integer userId) throws GlobalException;

    SellerStore getStoreByUserId(Integer userId) throws GlobalException;
}
