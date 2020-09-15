package com.yunji.common.exception;


/**
 * @Description: 异常枚举类
 * @author: du
 * @Date: 2020/9/7 8:47
 * @Modified:
 **/

public enum SoftManagerErrorEnum {
    //Enum采用大写加下划线组合
    SUCCESS("000001","SUCCESS") ,
    //1开头的为系统级异常
    SYSTEM_ERROR("100001","系统繁忙")

    //2 开头的为 模块***的异常

    //3开头的为 模块***的异常
    ;

    private String code;
    private String msg;

    SoftManagerErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
