package com.yunji.common.exception;


import com.yunji.common.common.ResponseInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = YunjiException.class)
    @ResponseBody
    public ResponseInfo bizExceptionHandler(YunjiException e) {
        ResponseInfo result = new ResponseInfo();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        result.setData(null);
        return result;
    }

    /**
     * 处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseInfo exceptionHandler( Exception e) {
        return new ResponseInfo(CommonErrorEnum.SYSTEM_ERROR ,e.toString());
    }
}
