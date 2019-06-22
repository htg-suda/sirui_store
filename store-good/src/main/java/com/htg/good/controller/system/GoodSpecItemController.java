package com.htg.good.controller.system;
import com.htg.common.entity.good.GoodSpecItem;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.exception.GlobalException;
import com.htg.good.service.IGoodSpecItemService;
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
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 规格参数名表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-05-29
 */
@Slf4j
@Api(value = "GoodSpecItemController", tags = "系统005-规格参数管理")
@Validated
@RestController
@RequestMapping("/sys/spec_item")
public class GoodSpecItemController {
    @Autowired
    private IGoodSpecItemService goodSpecItemService;

    @ApiOperation(value = "添加规格参数名")
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addGoodSpecItem(@Valid @RequestBody GoodSpecItem goodSpecItem) throws GlobalException {
        return goodSpecItemService.addGoodSpecItem(goodSpecItem);
    }

    /* 根据 group id 获取跟此group id 相关的 ,规格参数*/
    @ApiOperation(value = "获取规格参数名列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "分类id", defaultValue = "0", name = "categoryId", paramType = "path", dataType = "int", required = true),
            @ApiImplicitParam(value = "规格组id", defaultValue = "0", name = "groupId", paramType = "path", dataType = "int", required = true),
    })
    @ResponseBody
    @GetMapping("/list/{categoryId}/{groupId}")
    public CommonResult<RespList<GoodSpecItem>> list(@NotNull(message = "分类id 不能为空") @PathVariable Integer categoryId, @NotNull(message = "规格组id 不能为空") @PathVariable Integer groupId) throws GlobalException {
        return goodSpecItemService.listGoodSpecItem(categoryId, groupId);
    }


    @ApiOperation(value = "删除规格参数名")
    @ApiImplicitParams({@ApiImplicitParam(value = "规格参数id", defaultValue = "0", name = "specItemId", paramType = "path", dataType = "int", required = true),})
    @ResponseBody
    @DeleteMapping("/del/{specItemId}")
    public CommonResult<RespList<GoodSpecItem>> deleteSpecItem(@NotNull(message = "规格参数名id") @PathVariable Integer specItemId) {
        /*todo 这里直接删除可能导致商品中的规格 找不到引用 */
        if (goodSpecItemService.deleteById(specItemId)) {
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.error("删除失败");
        }
    }

}

