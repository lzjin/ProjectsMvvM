package com.he.skt.project.mvvm.entity;

/**
 * Description: 作用描述
 * Author: Administrator
 * CreateDate: 2020/4/7
 */
public class LoginBean {

    /**
     * token : TEzNDE4OTAzMTM5MTIzMiMxMzAxODIwNjcxMCNlMTBhZGMzOTQ5YmE1OWFiYmU1NmUwNTdmMjBmODgzZQ==MTIxO
     * status : -1
     * isOldUser : true
     */

    private String token;
    private int status;
    private boolean isOldUser;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isIsOldUser() {
        return isOldUser;
    }

    public void setIsOldUser(boolean isOldUser) {
        this.isOldUser = isOldUser;
    }
}
