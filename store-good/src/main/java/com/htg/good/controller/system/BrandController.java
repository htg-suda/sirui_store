package com.htg.good.controller.system;


import com.htg.common.dto.good.system.BrandDto;
import com.htg.common.entity.good.Brand;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.vo.good.BrandVo;
import com.htg.common.exception.GlobalException;
import com.htg.good.service.IBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */

@Slf4j
@Api(value = "BrandController", tags = "系统002-品牌管理")
@Validated
@RestController
@RequestMapping("/sys/brand")
public class BrandController {
    @Autowired
    private IBrandService brandService;


    @ApiOperation(value = "添加品牌", notes = "品牌需要审核")
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addBrand(@Valid @RequestBody Brand brand) throws GlobalException {
        return brandService.addBrand(brand);
    }


    @ApiOperation(value = "删除品牌")
    @ApiImplicitParams({@ApiImplicitParam(value = "品牌id", defaultValue = "0", name = "id", paramType = "path", dataType = "int", required = true)})
    @ResponseBody
    @DeleteMapping("/del/{id}")
    public CommonResult delBrand(@NotNull(message = "品牌Id不能为空") @PathVariable Integer id) throws GlobalException {
        return brandService.deleteBrand(id);
    }


    @ApiOperation(value = "获取所有品牌列表")
    @ResponseBody
    @GetMapping("/list")
    public CommonResult<RespList<BrandVo>> listBrand() {
        return brandService.listAllBrand();
    }

    /*修改品牌信息 和审核状态  */

    @ApiOperation(value = "修改品牌信息 和审核状态")
    @ResponseBody
    @PostMapping("/modify")
    public CommonResult modifyBrand(@Valid @RequestBody BrandDto brandDto) throws GlobalException {
        return brandService.modifyBrand(brandDto);
    }

    /* 修改基本信息 */


}

