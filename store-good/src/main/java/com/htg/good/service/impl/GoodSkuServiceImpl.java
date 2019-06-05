package com.htg.good.service.impl;

import com.htg.common.entity.GoodSku;
import com.htg.good.mapper.GoodSkuMapper;
import com.htg.good.service.IGoodSkuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品的sku 表,具体到某一款商品 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Service
public class GoodSkuServiceImpl extends ServiceImpl<GoodSkuMapper, GoodSku> implements IGoodSkuService {

}
