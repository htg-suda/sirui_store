package com.htg.sms_service.bean;
/*{"Message":"JSON参数不合法","RequestId":"866AE97C-0F8E-427D-8E1F-1918D37225CC","Code":"isv.INVALID_JSON_PARAM"}*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/* 表示 不知道的属性就不去序列化 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SMSResultBean {
    @JsonProperty(value = "Code")
    private String code;
    @JsonProperty(value = "RequestId")
    private String requestId;
    @JsonProperty(value = "Message")
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SMSResultBean{" +
                "code='" + code + '\'' +
                ", requestId='" + requestId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
