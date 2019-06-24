package com.htg.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.entity.seller.SellerStore;
import com.htg.user.mapper.SellerStoreMapper;
import com.htg.user.service.ISellerStoreService;
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
