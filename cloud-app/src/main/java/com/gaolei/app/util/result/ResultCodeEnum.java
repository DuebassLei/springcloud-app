package com.gaolei.app.util.result;

import lombok.Getter;
/**
 * 返回状态枚举类
 *
 * @author  DuebassLei
 * @version 1.0
 * @date  2020/9/21 13:29
 *
 */
@Getter
public enum  ResultCodeEnum {
    //操作失败
    FAILED(601,"操作失败"),
    //认证失败
    AUTH_ERROR(401,"认证失败"),
    //系统错误
    SYS_ERROR(500,"系统错误"),
    //参数错误
    PARAM_ERROR(400,"参数错误"),
    //未知错误
    UNKNOWN_ERROR(499,"未知错误"),
    //操作成功
    SUCCESS(200,"操作成功");

    private int code;
    private String message;
    ResultCodeEnum(){}

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message =message;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
