package com.universe.starry.common.exception;

import com.universe.starry.common.enums.ResultEnum;
import lombok.Data;

import java.text.MessageFormat;

/**
 * 自定义基础异常
 */
@Data
public class BasicException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6415098413164210639L;

	/**
	 * 错误编码
	 */
	private Integer code;
	
	/**
	 * 错误信息
	 */
	private String msg;

	/**
	 * 默认构造器
	 */
	public BasicException(){
        super();
    }
	
	public BasicException(ResultEnum renum) {
		super(renum.getMessage());
		this.code = renum.getCode();
		this.msg = renum.getMessage();
	}
	
	/**
	 * 异常构造器
	 * @param code
	 */
	public BasicException(Integer code) {
		this(code, ResultEnum.getMessage(code));
	}
	
	/**
	 * 异常构造器
	 * @param code
	 * @param message
	 */
	public BasicException(Integer code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}

	/**
	 * 异常构造器
	 * @param message
	 * @param cause
	 */
    public BasicException(String message, Throwable cause){
        super(message, cause);
    }

    /**
     * 异常构造器
     * @param cause
     */
    public BasicException(Throwable cause) {
        super(cause);
    }
    
	/**
	 * 异常构造器
	 * @param code 代码
	 * @param msgFormat 消息模板,内部会用MessageFormat拼接,模板类似:userid={0},message={1},date{2}
	 * @param args 具体参数的值
	 */
    public BasicException(Integer code, String msgFormat, Object... args) {
		super(MessageFormat.format(msgFormat, args));
		this.code = code;
		this.msg = MessageFormat.format(msgFormat, args);
	}
	
	/**
	 * 重写堆栈填充，不填充错误堆栈信息
	 * @return
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
	
}
