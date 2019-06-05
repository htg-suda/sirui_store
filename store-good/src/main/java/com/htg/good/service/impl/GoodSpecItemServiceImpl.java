package com.htg.good.service.impl;

import com.htg.common.entity.GoodSpecGroup;
import com.htg.common.entity.GoodSpecItem;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.good.constant.Del_FLAG;
import com.htg.good.exception.GlobalException;
import com.htg.good.mapper.GoodSpecItemMapper;
import com.htg.good.service.IGoodSpecGroupService;
import com.htg.good.service.IGoodSpecItemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 规格参数名表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Slf4j
@Service
public class GoodSpecItemServiceImpl extends ServiceImpl<GoodSpecItemMapper, GoodSpecItem> implements IGoodSpecItemService {

    @Autowired
    private IGoodSpecGroupService goodSpecGroupService;

    @Override
    public CommonResult<RespId> addGoodSpecItem(GoodSpecItem goodSpecItem) throws GlobalException {
        GoodSpecGroup goodSpecGroup = goodSpecGroupService.selectById(goodSpecItem.getGroupId());
        if (null == goodSpecGroup) {
            throw new GlobalException(CodeEnum.SPEC_GROUP_NOT_EXIST);
        }

        if (goodSpecGroup.getCategoryId() != goodSpecItem.getCategoryId()) {
            throw new GlobalException(CodeEnum.SPEC_ITEM_CATEGORT_ERROR);
        }

        List<GoodSpecItem> goodSpecItems = baseMapper.selectByGroupId(goodSpecItem.getGroupId());
        for (GoodSpecItem specItemExist : goodSpecItems) {
            if(specItemExist.getName().equals(goodSpecItem.getName())){
                throw new GlobalException(CodeEnum.SPEC_ITEM_HAS_EXIST);
            }
        }


        goodSpecGroup.setId(null);
        goodSpecGroup.setDelFlag(Del_FLAG.EXISTED);
        if (insert(goodSpecItem)) {
            return CommonResult.success(new RespId(goodSpecItem.getId()));
        } else {
            return CommonResult.error("添加失败");
        }
    }

    @Override
    public CommonResult<RespList<GoodSpecItem>> listGoodSpecItem(Integer categoryId, Integer groupId) {

        List<GoodSpecItem> goodSpecItems = baseMapper.selectByGroupId(groupId);

        List<GoodSpecItem> respItems = new ArrayList<>();
        for (GoodSpecItem goodSpecItem : goodSpecItems) {
            if (goodSpecItem.getCategoryId() != categoryId) {
                log.error("----- category id {}  error !-----", goodSpecItem.getCategoryId());
                continue;
            }
            respItems.add(goodSpecItem);
        }
        return CommonResult.success(new RespList<>(respItems));
    }
}
