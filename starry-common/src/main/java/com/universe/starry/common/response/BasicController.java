package com.universe.starry.common.response;

import com.alibaba.fastjson.JSONObject;
import com.universe.starry.common.enums.ResultEnum;

public class BasicController {
	
	protected Response result(Boolean success, Integer code, String message, Object data){
		Response result = new Response();
        result.setCode(code);
        result.setData(data == null ? null : JSONObject.toJSONString(data));
        result.setSuccess(success);
        result.setMessage(message);
        return result;
	}
	
	protected Response success(){
		return result(true, ResultEnum.OPERATE_SUCCESS.getCode(), ResultEnum.OPERATE_SUCCESS.getMessage(), null);
	}

	protected Response success(Object data){
		return result(true, ResultEnum.OPERATE_SUCCESS.getCode(), ResultEnum.OPERATE_SUCCESS.getMessage(), JSONObject.toJSONString(data));
	}
	
	protected Response error(Integer code){
		return result(false, code, ResultEnum.getMessage(code), null);
	}
	
	protected Response error(Integer code, String message){
		return result(false, code, message, null);
	}
}
