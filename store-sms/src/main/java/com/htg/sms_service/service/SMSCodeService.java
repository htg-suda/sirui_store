package com.htg.sms_service.service;

import com.aliyuncs.CommonResponse;
import com.aliyuncs.exceptions.ClientException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.htg.common.constant.CodeConst;
import com.htg.common.result.CommonResult;
import com.htg.sms_service.bean.SMSResultBean;
import com.htg.sms_service.utils.SMSUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class SMSCodeService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /*https://error-center.aliyun.com/status/product/Dysmsapi?spm=a2c4g.11186623.2.18.6d4556e00VxYpO*/
    private static String STATUS_OK = "OK";
    private static String STATUS_M_MC = "VALVE:M_MC";
    private static String STATUS_H_MC = "VALVE:H_MC";
    private static String STATUS_D_MC = "VALVE:D_MC";
    private static Logger logger = LoggerFactory.getLogger(SMSCodeService.class);
    /* 验证码存在的时间 为 300 秒*/
    private static int CODE_ACTIVE_TIME = 300;

    private static final boolean debug = true;

    /* 发送验证码 */
    public CommonResult sendSMSValidCodeMsg(String phoneNumbers) {
        String key = CodeConst.CODE_PREFIX + phoneNumbers;
        Long remainTime = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        logger.info("remainTime: " + remainTime);
        if (remainTime > 0 && CODE_ACTIVE_TIME - remainTime < 60) { // redis 中存在这个 验证码 ,并且验证码才产生少于60秒 ,就又去请求,就表示请求太过频繁
            return CommonResult.error("请求过于频繁,稍后再次尝试");
        }

        try {
            String code = RandomStringUtils.randomNumeric(6);
            if (debug) {
                redisTemplate.opsForValue().set(key, code, CODE_ACTIVE_TIME, TimeUnit.SECONDS);
                return CommonResult.success(code);
            }
            CommonResponse commonResponse = SMSUtils.sendCodeMsg(phoneNumbers, code);
            String data = commonResponse.getData();
            ObjectMapper mapper = new ObjectMapper();
            /*https://blog.csdn.net/shihuafu_/article/details/78611875*/
            SMSResultBean smsResultBean = mapper.readValue(data, SMSResultBean.class);
            String errCode = smsResultBean.getCode();
            if (errCode.equals(STATUS_OK)) { // 请求成功
                /* 存入 redis 数据库,只存在5 分钟*/
                redisTemplate.opsForValue().set(key, code, CODE_ACTIVE_TIME, TimeUnit.SECONDS);
                return CommonResult.success("发送成功");
            } else if (errCode.equals(STATUS_M_MC) || errCode.equals(STATUS_H_MC) || errCode.equals(STATUS_D_MC) || errCode.equals("isv.BUSINESS_LIMIT_CONTROL")) {
                logger.error("error: " + smsResultBean.toString());
                /* 业务流量限制 ,一天同一个手机号码只能发10条*/
                return CommonResult.error("请求过于频繁,稍后尝试");
            } else {
                logger.error("error: " + smsResultBean.toString());
                return CommonResult.error("请求验证码失败");
            }
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.error("请求验证码失败");
    }

}
