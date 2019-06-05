package com.htg.good.exception;

import com.htg.common.result.CodeEnum;

public class GlobalException extends Exception {
    private CodeEnum codeEnum;

    public GlobalException(CodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.codeEnum = codeEnum;
    }

    public Integer getCode() {
        return codeEnum.getCode();
    }

    public String getMsg() {
        return codeEnum.getMsg();
    }


}
