package com.he.skt.project.mvvm.https;

import com.he.skt.project.mvvm.https.api.ApiService;
import com.he.skt.project.mvvm.https.interceptor.LoggingInterceptor;
import com.he.skt.project.mvvm.utils.MLog;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description: 作用描述
 * Author: Administrator
 * CreateDate: 2020/4/7
 */
public class RetrofitService {

    private static String baseUrl = ApiService.Base_URL;
    private static final int DEFAULT_TIMEOUT = 5;
    public ApiService apiService;
    private static RetrofitService mRetrofit;

    public static RetrofitService getInstance() {
        if(mRetrofit==null) {
            synchronized (RetrofitService.class) {
                if (mRetrofit == null)
                    mRetrofit = new RetrofitService();
            }
        }
        baseUrl = ApiService.Base_URL;
        return mRetrofit;
    }

    private RetrofitService() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        if(MLog.isShowLogo){
            okHttpClient.addInterceptor(new LoggingInterceptor());//自定义拦截器
        }
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        apiService = retrofit.create(ApiService.class);
    }
}
