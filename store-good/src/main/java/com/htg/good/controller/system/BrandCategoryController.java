package com.htg.good.controller.system;


import com.htg.common.entity.good.BrandCategory;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.good.exception.GlobalException;
import com.htg.good.service.IBrandCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 品牌和分类的关系表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */

@Slf4j
@Api(value = "BrandCategoryController", tags = "系统003-分类和品牌关系管理")
@RestController
@RequestMapping("/sys/brand_category")
public class BrandCategoryController {
    @Autowired
    private IBrandCategoryService brandCategoryService;

    @ApiOperation(value = "关联品牌和分类")
    @Transactional
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addBrandCategory(@Valid @RequestBody BrandCategory brandCategory) throws GlobalException {
        return brandCategoryService.addBrandCategory(brandCategory);
    }


}

