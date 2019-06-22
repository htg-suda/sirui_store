package com.htg.sms_service.controller;

import com.htg.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.htg.sms_service.bean.SendBean;
import com.htg.sms_service.service.SMSCodeService;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(value = "SMS Controller", tags = "短信接口")
@RequestMapping("/sms")
public class SMSController {
    @Autowired
    private SMSCodeService smsCodeService;

    @ApiOperation("发送手机号码")
    @ResponseBody
    @PostMapping(value = "/send_code")
    public CommonResult getSMSCustomServiceMsg(@Valid @RequestBody SendBean sendBean) {
        String tel = sendBean.getTel();
        return smsCodeService.sendSMSValidCodeMsg(tel);
    }
}
