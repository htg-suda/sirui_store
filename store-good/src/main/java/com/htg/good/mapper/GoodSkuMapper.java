package com.htg.good.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.entity.good.GoodSku;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.htg.common.vo.good.user.UserQuerySkuVo;
import com.htg.common.dto.good.user.UserSkuQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 商品的sku 表,具体到某一款商品 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-05-2
 */
@Repository
public interface GoodSkuMapper extends BaseMapper<GoodSku> {

    List<GoodSku> selectBySpuId(Integer spuId);

  //  List<Integer> selectSpuByList(List<QueryBody> queryBodyList);

    //List<Integer> selectSpuBySpecList(List<QueryBody> queryBodyList);


    List<UserQuerySkuVo> selectSkuBySpecList(Page<UserQuerySkuVo> page, UserSkuQuery skuQuery);

    GoodSku selectBySkuNum(String skuNum);
}
