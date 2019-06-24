package com.htg.user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.htg.common.entity.seller.SellerStore;

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
