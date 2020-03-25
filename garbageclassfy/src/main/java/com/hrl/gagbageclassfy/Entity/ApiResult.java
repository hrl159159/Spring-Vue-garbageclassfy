package com.hrl.gagbageclassfy.Entity;

public class ApiResult<T> {
    /**
     * 错误码，请求成功是200,
     * 失败是400
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 将错误码和错误信息包装在data中
     */
    private T data;

    public ApiResult(){}
    public ApiResult(int code,String message,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

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
