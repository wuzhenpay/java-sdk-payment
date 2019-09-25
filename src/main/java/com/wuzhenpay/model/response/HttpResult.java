package com.wuzhenpay.model.response;


/**
 * Created by aspros on 16/9/19.
 */
public class HttpResult<T>
{
    public int code;
    public String message;
    public T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
