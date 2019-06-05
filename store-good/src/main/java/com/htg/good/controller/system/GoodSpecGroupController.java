package com.htg.good.controller.system;


import com.htg.common.entity.GoodSpecGroup;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.good.exception.GlobalException;
import com.htg.good.service.IGoodSpecGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 规格组表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Slf4j
@Validated
@Api(value = "GoodSpecGroupController", tags = "系统004-规格组管理")
@RestController
@RequestMapping("/sys/spec_group")
public class GoodSpecGroupController {
    @Autowired
    private IGoodSpecGroupService goodSpecGroupService;

    @ApiOperation(value = "添加规格组")
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> add(@RequestBody GoodSpecGroup specGroup) throws GlobalException {
        return goodSpecGroupService.addSpecGroup(specGroup);
    }


    @ApiOperation(value = "获取规格组列表")
    @ResponseBody
    @PostMapping("/list/{categoryId}")
    public CommonResult<RespList<GoodSpecGroup>> list(@NotNull(message = "分类id不能为空") @PathVariable Integer categoryId) throws GlobalException {
        return goodSpecGroupService.listByCategoryId(categoryId);
    }

}

