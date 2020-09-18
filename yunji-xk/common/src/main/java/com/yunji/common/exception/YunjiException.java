package com.yunji.common.exception;

import lombok.Data;

/**
 * @Description: 异常类,各业务异常需要继承此异常 ，业务类如有不能处理异常也要抛出此异常
 * @author: du
 * @Date: 2020/9/7 8:47
 * @Modified:
 **/

@Data
public class YunjiException extends RuntimeException {

    //protected HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;

    private String code;
    private String msg;

    public YunjiException(CommonErrorEnum enumInfo) {
        this.code = enumInfo.getCode();
        this.msg = enumInfo.getMsg();
    }

    public YunjiException(String code, String msg) {
        super(msg);
        this.code = code;
    }

}
