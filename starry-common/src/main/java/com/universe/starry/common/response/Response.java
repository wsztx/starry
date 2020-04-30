package com.universe.starry.common.response;

import com.alibaba.fastjson.JSON;
import com.universe.starry.common.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 是否成功
     */
    private Boolean success;

    public Response() {
        super();
    }

    public Response(Boolean success, ResultEnum renum) {
        super();
        this.success = success;
        this.code = renum.getCode();
        this.message = renum.getMessage();
    }

    public Response(Boolean success, Integer code, String message) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return toJSONString();
    }
}
