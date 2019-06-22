package com.htg.seller.mapper;

import com.htg.common.entity.seller.SellerStore;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 商铺表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
public interface SellerStoreMapper extends BaseMapper<SellerStore> {

    SellerStore selectBySn(String sn);
}
