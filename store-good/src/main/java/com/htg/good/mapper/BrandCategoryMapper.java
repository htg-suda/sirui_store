package com.htg.good.mapper;

import com.htg.common.entity.good.BrandCategory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 品牌和分类的关系表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Repository
public interface BrandCategoryMapper extends BaseMapper<BrandCategory> {
    Integer checkNumByCategoryBrand(Integer categoryId, Integer brandId);

    List<BrandCategory> selectbyCategoryIdOrBrandId(Integer categoryId, Integer brandId);
}
