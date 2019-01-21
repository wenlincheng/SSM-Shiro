package com.wenlincheng.ssm.exception;

/**
 * @ClassName CustomException 
 * @Description 自定义异常类
 * @author Cheng
 * @date 2018年10月7日 上午11:56:24
 */
public class CustomException extends Exception {
	/** serialVersionUID*/
	private static final long serialVersionUID = -5212079010855161498L;

    /**
     * @MethodName: CustomException
     * @Description: 构造函数
     * @Params: [message]
     * @Return:
     * @Author:
     * @Date:
     */
	public CustomException(String message) {
		super(message);
		this.message = message;
	}

    /**
     * 异常信息
     */
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
