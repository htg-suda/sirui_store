package com.htg.good.mapper;

import com.htg.common.entity.good.Brand;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
public interface BrandMapper extends BaseMapper<Brand> {
     List<Brand> selectByName(String nameCN,String nameEG);

     List<Brand> selectAll();
}
