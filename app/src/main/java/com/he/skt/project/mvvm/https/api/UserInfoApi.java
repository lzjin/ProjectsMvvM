package com.he.skt.project.mvvm.https.api;

import com.google.gson.JsonObject;
import com.he.skt.project.mvvm.base.BaseResponseBean;
import com.he.skt.project.mvvm.entity.LoginBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/5/24
 */
public interface UserInfoApi {
    /**
     * 刷新token
     **/
    @FormUrlEncoded
    @POST("oauth/token")
    Call<JsonObject> getRefToken(@Header("Authorization") String contentRange, @Field("grant_type") String grandtype, @Field("refresh_token") String refresh_token);

    //登录
    @Headers("Content-type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("uapi/api/pub/user/login2")
    Observable<BaseResponseBean<LoginBean>> login2(@FieldMap Map<String, Object> map);


}
