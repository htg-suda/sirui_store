package com.htg.good.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.entity.good.SpuGoodSpecValue;
import com.htg.good.mapper.SpuGoodSpecValueMapper;
import com.htg.good.service.ISpuGoodSpecValueService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品spu规格值表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-05
 */
@Service
public class SpuGoodSpecValueServiceImpl extends ServiceImpl<SpuGoodSpecValueMapper, SpuGoodSpecValue> implements ISpuGoodSpecValueService {

    @Override
    public List<SpuGoodSpecValue> selectBySpuId(Integer spuId) {
        return baseMapper.selectBySpuId(spuId);

    }
}
