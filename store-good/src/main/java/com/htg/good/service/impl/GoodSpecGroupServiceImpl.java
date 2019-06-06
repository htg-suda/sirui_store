package com.htg.good.service.impl;

import com.htg.common.entity.good.GoodCategory;
import com.htg.common.entity.good.GoodSpecGroup;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.good.constant.Del_FLAG;
import com.htg.good.exception.GlobalException;
import com.htg.good.mapper.GoodSpecGroupMapper;
import com.htg.good.service.IGoodCategoryService;
import com.htg.good.service.IGoodSpecGroupService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 规格组表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Service
public class GoodSpecGroupServiceImpl extends ServiceImpl<GoodSpecGroupMapper, GoodSpecGroup> implements IGoodSpecGroupService {

    @Autowired
    private IGoodCategoryService goodCategoryService;

    @Override
    public CommonResult<RespId> addSpecGroup(GoodSpecGroup goodSpecGroup) throws GlobalException {
        Integer categoryId = goodSpecGroup.getCategoryId();
        String name = goodSpecGroup.getName();
        Integer count = baseMapper.selectCountByCategoryIdAndName(categoryId, name);
        if (count > 0) {
            throw new GlobalException(CodeEnum.SPEC_GROUP_HAS_EXIST);
        }

        GoodCategory goodCategory = goodCategoryService.selectById(categoryId);
        if (null == goodCategory) {
            throw new GlobalException(CodeEnum.CATEGORY_NOT_EXIST);
        }

        goodSpecGroup.setId(null);
        goodSpecGroup.setDelFlag(Del_FLAG.EXISTED);
        if (insert(goodSpecGroup)) {
            return CommonResult.success(new RespId(goodSpecGroup.getId()));
        } else {
            return CommonResult.error("添加失败");
        }

    }

    @Override
    public CommonResult<RespList<GoodSpecGroup>> listByCategoryId(Integer categoryId) throws GlobalException {
        GoodCategory goodCategory = goodCategoryService.selectById(categoryId);
        if (null == goodCategory) {
            throw new GlobalException(CodeEnum.CATEGORY_NOT_EXIST);
        }
        List<GoodSpecGroup> goodSpecGroups = baseMapper.selectSpecGroupByCategoryId(categoryId);
        return CommonResult.success(new RespList<>(goodSpecGroups));
    }
}
