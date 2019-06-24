package com.htg.common.exception;

import com.htg.common.result.CodeEnum;

public class GlobalException  extends RuntimeException{
    private CodeEnum codeEnum;

    public GlobalException(CodeEnum codeEnum) {
        this.codeEnum = codeEnum;
    }

    public Integer getCode() {
        return codeEnum.getCode();
    }

    public String getMsg() {
        return codeEnum.getMsg();
    }

    @Override
    public String toString() {
        return "GlobalException{" +
                "codeEnum=" + codeEnum +
                '}';
    }
}
