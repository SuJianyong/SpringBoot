package com.yunji.xc.common.utils;

import cn.hutool.http.HttpStatus;
import lombok.Data;

@Data
public class RestResponse<T> {
    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private T data;

    public static RestResponse build(Integer status, String msg, Object data) {
        return new RestResponse(status, msg, data);
    }

    public static RestResponse ok(Object data) {
        return new RestResponse(data);
    }

    public static RestResponse ok() {
        return new RestResponse(null);
    }

    public static RestResponse error(Integer status, String msg) {
        return new RestResponse(status, msg, null);
    }

    public static RestResponse errorMsg(String msg) {
        return new RestResponse(HttpStatus.HTTP_INTERNAL_ERROR, msg, null);
    }

    public static RestResponse errorMap(Object data) {
        return new RestResponse(HttpStatus.HTTP_NOT_IMPLEMENTED, "error", data);
    }

    public static RestResponse errorTokenMsg(String msg) {
        return new RestResponse(HttpStatus.HTTP_BAD_GATEWAY, msg, null);
    }

    public static RestResponse errorException(String msg) {
        return new RestResponse(HttpStatus.HTTP_VERSION, msg, null);
    }

    public boolean isSuccess() {
        return HttpStatus.HTTP_OK == this.code;
    }

    public RestResponse() {

    }

    public RestResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse(T data) {
        this.code = HttpStatus.HTTP_OK;
        this.msg = "OK";
        this.data = data;
    }

}
