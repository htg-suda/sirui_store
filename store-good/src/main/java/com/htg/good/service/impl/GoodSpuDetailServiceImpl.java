package com.htg.good.service.impl;

import com.htg.common.entity.GoodSpuDetail;
import com.htg.good.mapper.GoodSpuDetailMapper;
import com.htg.good.service.IGoodSpuDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品spu详情表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Service
public class GoodSpuDetailServiceImpl extends ServiceImpl<GoodSpuDetailMapper, GoodSpuDetail> implements IGoodSpuDetailService {

    @Override
    public GoodSpuDetail selectBySpuId(Integer spuId) {
        return baseMapper.selectBySpuId(spuId);
    }
}
