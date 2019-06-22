package com.htg.seller.service.impl;

import com.htg.common.entity.seller.SellerStore;
import com.htg.seller.mapper.SellerStoreMapper;
import com.htg.seller.service.ISellerStoreService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商铺表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
@Service
public class SellerStoreServiceImpl extends ServiceImpl<SellerStoreMapper, SellerStore> implements ISellerStoreService {

    @Override
    public SellerStore selectBySn(String sn) {
        return baseMapper.selectBySn(sn);
    }
}
