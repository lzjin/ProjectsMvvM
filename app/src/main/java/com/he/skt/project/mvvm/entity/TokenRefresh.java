package com.he.skt.project.mvvm.entity;

/**
 * Description: token过期刷新token
 * Author: Lzj
 * CreateDate: 2020/5/24
 */
public class TokenRefresh {
    private String expiration;
    private String value;

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
