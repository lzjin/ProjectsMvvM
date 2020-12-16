package com.he.skt.project.mvvm.https.interceptor;

import com.he.skt.project.mvvm.utils.MLog;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 接口重试机制
 */
public class RetryInterceptor implements Interceptor {
    private int mMaxRetryCount;//最大重试次数
    private long mRetryInterval;

    public RetryInterceptor(int maxRetryCount, long retryInterval) {
        mMaxRetryCount = maxRetryCount;
        mRetryInterval = retryInterval;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);//执行请求
        String url = request.url().toString();
        if (url.contains("/authentication/form")){
            // 改url需要重试
        }
        int retryNum = 0;
        while(!response.isSuccessful()&&retryNum<mMaxRetryCount){
            try {
                Thread.sleep(mRetryInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retryNum++;
            response = chain.proceed(request);
            MLog.e("--------------------重试次数="+retryNum);
        }
        return response;
    }

}
