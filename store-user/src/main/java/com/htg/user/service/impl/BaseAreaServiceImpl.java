package com.htg.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.entity.area.BaseArea;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespList;
import com.htg.user.mapper.BaseAreaMapper;
import com.htg.user.service.IBaseAreaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-25
 */
@Service
public class BaseAreaServiceImpl extends ServiceImpl<BaseAreaMapper, BaseArea> implements IBaseAreaService {

    @Override
    public CommonResult<RespList<BaseArea>> getBaseAreaByParentId(Integer parentId) {
        List<BaseArea> areas = baseMapper.selectByParentId(parentId);
        return CommonResult.success(new RespList<>(areas));
    }

    @Override
    public CommonResult<BaseArea> getBaseAreaByCodeId(Integer codeId) {
        BaseArea areas = baseMapper.selectByCodeId(codeId);
        return CommonResult.success(areas);
    }
}
