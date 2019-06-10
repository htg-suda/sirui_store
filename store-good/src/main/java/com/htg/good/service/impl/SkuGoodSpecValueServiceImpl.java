package com.htg.good.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.entity.good.SkuGoodSpecValue;
import com.htg.good.mapper.SkuGoodSpecValueMapper;
import com.htg.good.service.ISkuGoodSpecValueService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品sku规格值表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
@Service
public class SkuGoodSpecValueServiceImpl extends ServiceImpl<SkuGoodSpecValueMapper, SkuGoodSpecValue> implements ISkuGoodSpecValueService {

    @Override
    public List<SkuGoodSpecValue> selectBySkuId(Integer skuId) {
        return baseMapper.selectBySkuId(skuId);
    }
}
