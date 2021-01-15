package com.emi2c.mybatis.entity;

/**
 * 统一返回结果
 * @param <T>
 */
public class Result<T> {

    public static final int success = 0;
    public static final int fail = 1;
    private int status = success;
    private String message = "success";
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
