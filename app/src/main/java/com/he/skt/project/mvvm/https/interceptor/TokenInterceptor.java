package com.he.skt.project.mvvm.https.interceptor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.he.skt.project.mvvm.contants.AppConstant;
import com.he.skt.project.mvvm.contants.HttpConstant;
import com.he.skt.project.mvvm.entity.TokenRoot;
import com.he.skt.project.mvvm.https.api.UserInfoApi;
import com.he.skt.project.mvvm.prefs.AppPreference;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description ： 请求头与 过期重登
 * author : asus
 * date : 2020/11/16
 */
public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String url = chain.request().url().toString();
        String token = AppPreference.getString("token","");
        Request.Builder request = chain.request().newBuilder();
        if (!url.contains("/authentication/form") && !url.contains("/auth/weixin") && !url.contains("/authentication/mobile")) {
            //接口不加token,已经加过
            request.addHeader("Authorization", token);
        }
        Response proceed = chain.proceed(request.build());
        //如果token过期,去重新请求token 然后设置token的请求头 重新发起请求 用户无感
        if (isTokenExpired(proceed)) {
            if (token.equals("")) {
                // IntentManager.toLoginActivity(context);
            } else {
                String newHeaderToken = getNewToken();
                //使用新的Token，创建新的请求
                Request newRequest = chain.request().newBuilder().addHeader("Authorization", newHeaderToken).build();
                return chain.proceed(newRequest);
            }
        }
        //如果用户被挤下线
        if (isOffLine(proceed)) {
            AppPreference.clearAll();//移除sp
            // IntentManager.toLoginActivity(context);
        }
        return proceed;
    }

    /**
     * 同步请求方式，获取最新的Token
     *
     * @return
     */
    private String getNewToken() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserInfoApi userApi = retrofit.create(UserInfoApi.class);
        String refreshToken = AppPreference.getString("refreshToken","");
        retrofit2.Call<JsonObject> refToken = userApi.getRefToken(AppConstant.SP_BASE_TOKEN, "refresh_token", refreshToken);
        retrofit2.Response<JsonObject> response = refToken.execute();
        if (null != response.body() && null != response.body().getAsJsonObject()) {
            JsonObject jsonObject = response.body().getAsJsonObject();
            Gson gson = new Gson();
            TokenRoot tokenBean = gson.fromJson(jsonObject, TokenRoot.class);
            if (null != tokenBean.getData()) {
                AppPreference.putString(AppConstant.SP_TOKEN, "bearer " + tokenBean.getData().getValue());
                AppPreference.putString(AppConstant.SP_REFRESHTOKEN, tokenBean.getData().getRefreshToken().getValue());
                return "bearer " + tokenBean.getData().getValue();
            }
        }
        return "";
    }

    /**
     * 根据Response，判断Token是否失效
     * 401表示token过期
     *
     * @param response
     * @return
     */
    private boolean isTokenExpired(Response response) {
        if (response.code() == 401) {
            return true;
        }
        return false;
    }
    /**
     * 根据Response，判断Token是否失效
     * 402表示用户被挤下线
     *
     * @param response
     * @return
     */
    private boolean isOffLine(Response response) {
        if (response.code() == 402) {
            return true;
        }
        return false;
    }
}
