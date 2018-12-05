package com.wuzhenpay.model;

/**
 * Created by aspros on 16/9/19.
 */
public class HttpResult<T>
{
    public int code;
    public String message;
    public String errorMsg;
    public T data;
}
