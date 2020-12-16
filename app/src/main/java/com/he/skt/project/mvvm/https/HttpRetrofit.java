package com.he.skt.project.mvvm.https;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.he.skt.project.mvvm.contants.HttpConstant;
import com.he.skt.project.mvvm.https.api.DownloadApi;
import com.he.skt.project.mvvm.https.interceptor.LoggingInterceptor;
import com.he.skt.project.mvvm.https.interceptor.ProgressResponseBody;
import com.he.skt.project.mvvm.https.interceptor.RetryInterceptor;
import com.he.skt.project.mvvm.https.interceptor.TokenInterceptor;
import com.he.skt.project.mvvm.listener.ProgressListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description: 网络框架Retrofit封装
 * Author: Lzj
 * CreateDate: 2020/5/24
 */
public class HttpRetrofit {
    private static String BASE_URL = HttpConstant.BASE_URL2;
    private static final int DEFAULT_TIMEOUT = 5;
    private static HttpRetrofit httpRetrofit;
    public static Retrofit retrofit;
    public static OkHttpClient okHttpClient;
    private Context context;

    private final static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .serializeNulls()// 调用serializeNulls方法，改变gson对象的默认行为，null值将被输出
            .create();

    public static HttpRetrofit getInstance(Context contextRet) {
        if(httpRetrofit==null) {
            synchronized (HttpRetrofit.class) {
                if (httpRetrofit == null)
                    httpRetrofit = new HttpRetrofit(contextRet);
            }
        }
        BASE_URL =  HttpConstant.BASE_URL;
        return httpRetrofit;
    }

    public HttpRetrofit(Context contextRet) {
        this.context = contextRet;
        init();
    }

    private void init(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new RetryInterceptor(5,1000))//重试
                .addInterceptor(new TokenInterceptor()) // 请求头与过期重登
                .addInterceptor(new LoggingInterceptor()) //日志
                .build();
    }

    /**
     * 获取网络加载器器
     */
    public static <T> T createApi(Class<T> clazz) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        T t = retrofit.create(clazz);
        if (t instanceof DownloadApi) {//判断是否是DownloadApi
            return downloadApk().create(clazz);
        }
        return t;
    }
    /**
     * 获取网络加载器器
     */
    public static <T> T createApi(Class<T> clazz, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        T t = retrofit.create(clazz);
        return t;
    }

    private  static Retrofit downloadApk(){
        Retrofit retrofitDownload = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient.newBuilder().addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response orginalResponse = chain.proceed(chain.request());
                        return orginalResponse.newBuilder()
                                .body(new ProgressResponseBody(orginalResponse.body(), new ProgressListener() {
                                    @Override
                                    public void onProgress(long progress, long total, boolean done) {
                                        // EventBus.getDefault().post(new ProgressEvent(total, progress, done));//传递进度
                                    }
                                })).build();
                    }
                }).build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofitDownload;
    }

}
