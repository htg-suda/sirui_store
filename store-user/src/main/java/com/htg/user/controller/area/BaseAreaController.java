package com.htg.user.controller.area;
import com.htg.common.entity.area.BaseArea;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespList;
import com.htg.user.service.IBaseAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "BaseAreaController", tags = "004-省市县查询")
@Validated
@RestController
@RequestMapping("/area")
public class BaseAreaController {

    @Autowired
    private IBaseAreaService areaService;

    @ApiOperation(value = "通过父id 获取省市县,parentId为0时是省级别")
    @ResponseBody
    @GetMapping("/get_area_by_parent_id/{parentId}")
    public CommonResult<RespList<BaseArea>> getBaseAreaByParentId(@PathVariable("parentId") Integer parentId) throws GlobalException {

        return areaService.getBaseAreaByParentId(parentId);
    }

    @ApiOperation(value = "通过id 获取省市县")
    @ResponseBody
    @GetMapping("/get_area_by_code_id/{codeId}")
    public CommonResult<BaseArea> getBaseAreaByCodeId(@PathVariable("codeId") Integer codeId) throws GlobalException {

        return areaService.getBaseAreaByCodeId(codeId);
    }
}