package com.he.skt.project.mvvm.https.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/5/24
 */
public interface DownloadApi {
    /**
     * 下载文件
     */
    @Streaming
    @GET
    Call<ResponseBody> downloadFileWithDynamicUrlSync(@Url String url);
}
