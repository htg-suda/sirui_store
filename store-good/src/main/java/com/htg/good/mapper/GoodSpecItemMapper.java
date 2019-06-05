package com.htg.good.mapper;

import com.htg.common.entity.GoodSpecItem;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 * 规格参数名表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface GoodSpecItemMapper extends BaseMapper<GoodSpecItem> {
    List<GoodSpecItem> selectByGroupId(Integer groupId);
}
