package com.springboot.fileupload.response;

import cn.hutool.http.HttpStatus;
import lombok.Data;

@Data
public class Result {
    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static Result build(Integer status, String msg, Object data) {
        return new Result(status, msg, data);
    }

    public static Result ok(Object data) {
        return new Result(data);
    }

    public static Result ok() {
        return new Result(null);
    }

    public static Result error(Integer status, String msg) {
        return new Result(status, msg, null);
    }

    public static Result errorMsg(String msg) {
        return new Result(HttpStatus.HTTP_INTERNAL_ERROR, msg, null);
    }

    public static Result errorMap(Object data) {
        return new Result(HttpStatus.HTTP_NOT_IMPLEMENTED, "error", data);
    }

    public static Result errorTokenMsg(String msg) {
        return new Result(HttpStatus.HTTP_BAD_GATEWAY, msg, null);
    }

    public static Result errorException(String msg) {
        return new Result(HttpStatus.HTTP_VERSION, msg, null);
    }

    public boolean isSuccess() {
        return HttpStatus.HTTP_OK == this.code;
    }

    public Result() {

    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Object data) {
        this.code = HttpStatus.HTTP_OK;
        this.msg = "OK";
        this.data = data;
    }

}
