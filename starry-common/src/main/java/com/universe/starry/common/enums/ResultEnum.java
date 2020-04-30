package com.universe.starry.common.enums;

/**
 * 操作结果枚举类
 * @author zhoutianxiang
 *
 */
public enum ResultEnum {
	
	OPERATE_SUCCESS(0, "success."),
	OPERATE_FAIL(1, "fail.");
	
	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;
	
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static String getMessage(Integer code){
		String message = "";
		if(code != null){
			for (ResultEnum e : ResultEnum.values()) {
				if(e.getCode().equals(code)){
					message = e.getMessage();
					break;
				}
			}
		}
		return message;
	}
}
