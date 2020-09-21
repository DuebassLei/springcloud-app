package com.gaolei.app.util.result;

import com.gaolei.app.util.ice.IceGenUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回值结果集封装
 *
 * @author  DuebassLei
 * @version 1.0
 * @date  2020/9/21 13:29
 *
 */

@Data
public class ResultCodeMsg<T> implements Serializable {
    private static final long serialVersionUID = -7238918678136393125L;
    /**
     * http响应状态码
     * */
    private int code;
    /**
     * 返回提示消息
     * */
    private String msg;
    /**
     * 返回的数据
     * */
    private T data;

    public ResultCodeMsg() {

    }

    public ResultCodeMsg(ResultCodeEnum msg) {
        this.code = msg.getCode();
        this.msg = msg.getMessage();
    }

    public ResultCodeMsg(ResultCodeEnum msg, T data) {
        this.code = msg.getCode();
        this.msg = msg.getMessage();
        this.data = data;
    }

    public static void main(String[] args) {
        System.out.println(new ResultCodeMsg(ResultCodeEnum.SUCCESS,"test"));
        System.out.println(IceGenUtil.forij());
    }
}
