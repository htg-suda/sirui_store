package com.htg.good.controller.system;
import com.htg.common.dto.system.GoodCategoryDto;
import com.htg.common.entity.GoodCategory;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.vo.BrandVo;
import com.htg.common.vo.GoodCategoryVo;
import com.htg.good.exception.GlobalException;
import com.htg.good.service.IGoodCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商品分类表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Slf4j
@Api(value = "GoodCategoryController", tags = "系统001-分类管理")
@RestController
@RequestMapping("/sys/category")
// 注解必须写在这里,参数校验不过会有 ConstraintViolationException 异常
@Validated
public class GoodCategoryController {
    @Autowired
    private IGoodCategoryService goodCategoryService;


    @ApiOperation(value = "添加分类", notes = "添加分类")
    @Transactional
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addCategory(@Valid @RequestBody GoodCategory goodCategory) throws GlobalException {
        return goodCategoryService.addCategory(goodCategory);
    }


    @ApiOperation(value = "获取子分类", notes = "根据id获取")
    @ApiImplicitParams({@ApiImplicitParam(value = "分类的id ,id为0的时候是根分类", defaultValue = "0", name = "categoryId", paramType = "path", dataType = "int", required = true)})
    @ResponseBody
    @GetMapping("/list_child_category/{categoryId}")
    public CommonResult<RespList<GoodCategoryVo>> getChildCategory(@NotNull(message = "分类id不能为空") @Min(0) @PathVariable Integer categoryId) {
        return goodCategoryService.listChildCategory(categoryId);
    }


    @ApiOperation(value = "获取分类下品牌", notes = "根据id获取")
    @ApiImplicitParams({@ApiImplicitParam(value = "categoryId 分类id", defaultValue = "0", name = "categoryId", paramType = "path", dataType = "int", required = true)})
    @ResponseBody
    @GetMapping("/list_brand/{categoryId}")
    public CommonResult<RespList<BrandVo>> getBrandList(@NotNull(message = "分类id不能为空") @Min(0) @PathVariable Integer categoryId) {
        return goodCategoryService.listBrandById(categoryId);
    }


    /* 修改商品分类信息 */
    //todo 删除分类,由于分类下有商品,删除一个分类是会有很大的影响的,先不删除



    @ApiOperation(value = "添加分类", notes = "添加分类")
    @Transactional
    @ResponseBody
    @PostMapping("/modify")
    public CommonResult modifyCategory(@Valid @RequestBody GoodCategoryDto goodCategoryDto) throws GlobalException {
        return goodCategoryService.modifyCategory(goodCategoryDto);
    }

}

