package com.he.skt.project.mvvm.entity;

import java.util.List;

/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/5/24
 */
public class TokenBean {
    private Object additionalInformation;//Object{...},
    private String expiration;//1545121697075,
    private String expired;//false,
    private String expiresIn;//86399,
    private TokenRefresh refreshToken;//Object{...},
    private List<Object> scope;//Array[3],
    private String tokenType;//"bearer",
    private String value;//"

    public Object getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Object additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public TokenRefresh getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(TokenRefresh refreshToken) {
        this.refreshToken = refreshToken;
    }

    public List<Object> getScope() {
        return scope;
    }

    public void setScope( List<Object> scope) {
        this.scope = scope;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
