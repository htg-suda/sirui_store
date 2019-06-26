package com.htg.user.controller.system;
import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.bo.user.SrUserBO;
import com.htg.common.dto.custom.CustomSearchDto;
import com.htg.common.entity.custom.CustomServiceInfo;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.*;
import com.htg.common.vo.user.admin.CustomServiceUserInfoVo;
import com.htg.common.vo.user.admin.UserInfoWithId;
import com.htg.user.service.ICustomServiceInfoService;
import com.htg.user.service.ISrUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * <p>
 * 客服信息表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-06-25
 */

@Slf4j
@Api(value = "CustomServiceInfoController", tags = "005-客服管理")
@Validated
@RestController
@RequestMapping("/sys")
public class SysCustomServiceInfoController {

    /* 将普通用户添加为客服 */
    @Autowired
    private ICustomServiceInfoService customServiceInfoService;

    @Autowired
    private ISrUserService srUserService;

    @ApiOperation(value = "管理员添加普通用户添加为客服")
    @ResponseBody
    @PostMapping("/custom_service/add")
    public CommonResult<RespId> addCustomServiceInfo(@Valid @RequestBody CustomServiceInfo customServiceInfo) throws GlobalException {
        return customServiceInfoService.addCustomServiceInfo(customServiceInfo);
    }


    /* 检索客服 */
    @ApiOperation(value = "根据手机查找用户,检索用户以添加为客服")
    @ResponseBody
    @GetMapping("/custom_service/search_by_tel/{tel}")
    public CommonResult<UserInfoWithId> getUserByTel(@PathVariable("tel") String tel) {
        SrUserBO srUserBO = srUserService.getUserByTel(tel);

        if (srUserBO == null) {
            throw new GlobalException(CodeEnum.USER_NOT_EXIST);
        }
        UserInfoWithId userInfo = new UserInfoWithId();
        BeanUtils.copyProperties(srUserBO, userInfo);
        return CommonResult.success(userInfo);
    }


    /* 检索客服 */
    @ApiOperation(value = "获取客服列表")
    @ResponseBody
    @PostMapping("/custom_service/list")
    public CommonResult<RespPage<CustomServiceUserInfoVo>> searchCustomService(@Valid @RequestBody CustomSearchDto customSearchDto) {
        Integer pageNum = customSearchDto.getPageNum();
        Integer pageSize = customSearchDto.getPageSize();
        Page<CustomServiceUserInfoVo> page = new Page<>(pageNum, pageSize);
        String serviceName = customSearchDto.getServiceName();
        if (serviceName != null) {
            serviceName = "%" + serviceName + "%";
        }
        String tel = customSearchDto.getTel();
        log.info("========>name is  {},tel is {}", serviceName, tel);
        return customServiceInfoService.searchCustomSerivce(page, tel, serviceName);
    }

    /* 检索客服 */
    @ApiOperation(value = "根据客服id获取客服信息")
    @ResponseBody
    @PostMapping("/custom_service/get_info_by_id/{id}")
    public CommonResult<CustomServiceUserInfoVo> getCustomServiceInfoById(@PathVariable("id") Integer id) {
        return customServiceInfoService.getCustomServiceInfoById(id);
    }

}

