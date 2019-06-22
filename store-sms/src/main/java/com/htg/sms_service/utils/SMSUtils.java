package com.htg.sms_service.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/* https://help.aliyun.com/document_detail/101414.html */
public class SMSUtils {
    private static String accessKeyId = "LTAIWSuxcn9dvX0K";
    private static String accessSecret = "mph9I4Az8DuvWoQPCB3Q2CvoH2v25p";

    public static CommonResponse sendCodeMsg(String phoneNum, String code) throws ClientException {
        /**
         * 地域ID
         * RAM账号的AccessKey ID
         * RAM账号Access Key Secret
         */
        DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        // 创建API请求并设置参数
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        /* 设置 action 为发短信*/
        request.setAction("SendSms");
        /* 接收短信的手机号码. */
        request.putQueryParameter("PhoneNumbers", phoneNum);

        /* 短信签名名称。请在控制台签名管理页面签名名称一列查看。*/
        request.putQueryParameter("SignName", "偲睿科技智能工位");

        /* 短信模板ID。请在控制台模板管理页面模板CODE一列查看 */
        request.putQueryParameter("TemplateCode", "SMS_120115970");

        request.putQueryParameter("TemplateParam", "{ \"code\":\"" + code + "\"}");

        CommonResponse response = client.getCommonResponse(request);
        //  System.out.println(response.getData());
        return response;
    }


}
