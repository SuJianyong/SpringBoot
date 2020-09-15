package com.yunji.common.common;

import com.yunji.common.exception.CommonErrorEnum;
import lombok.Data;

/**
 * @Description: 返回数据结构
 * @author: du
 * @Date: 2020/9/7 8:47
 * @Modified:
 **/
@Data
public class ResponseInfo<T> {
    private String code;
    private T data;
    private String msg;

    /**
     * 适用于返回数据，以及执行状态
     *
     * @param enumInfo
     * @param data
     */
    public ResponseInfo(CommonErrorEnum enumInfo, T data) {
        this.code = enumInfo.getCode();
        this.msg = enumInfo.getMsg();
        this.data = data;
    }

    /**
     * 适用于返回数据，以及执行状态
     *
     * @param data
     */
    public ResponseInfo(T data) {
        this.code = CommonErrorEnum.SUCCESS.getCode();
        this.msg = CommonErrorEnum.SUCCESS.getMsg();
        this.data = data;
    }

    /**
     * 适用于只返回执行状态
     *
     * @param enumInfo
     */
    public ResponseInfo(CommonErrorEnum enumInfo) {
        this.code = enumInfo.getCode();
        this.msg = enumInfo.getMsg();
    }

    public ResponseInfo() {
    }

    /**
     * 适应于自定义状态信息
     *
     * @param code
     * @param msg
     */
    public ResponseInfo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}