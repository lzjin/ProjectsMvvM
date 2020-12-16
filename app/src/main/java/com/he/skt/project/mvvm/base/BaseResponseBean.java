package com.he.skt.project.mvvm.base;

import java.io.Serializable;

/**
 * Description: 实体类的基类
 * Author: Administrator
 * CreateDate: 2020/4/7
 */
public class BaseResponseBean<T> implements Serializable {

    /**
     * data : {"token":"TEzNDE4OTAzMTM5MTIzMiMxMzAxODIwNjcxMCNlMTBhZGMzOTQ5YmE1OWFiYmU1NmUwNTdmMjBmODgzZQ==MTIxO","status":-1,"isOldUser":true}
     * code : 10000
     * message : 操作成功
     */
    private T data;
    private int code;
    private String message;

    public BaseResponseBean(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponseBean(T data, int code) {
        this.data = data;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
}
