package com.htg.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.entity.seller.SellerStore;

/**
 * <p>
 * 商铺表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
public interface ISellerStoreService extends IService<SellerStore> {

    SellerStore selectBySn(String sn);

}
