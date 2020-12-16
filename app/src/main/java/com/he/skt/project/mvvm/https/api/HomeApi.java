package com.he.skt.project.mvvm.https.api;




import com.he.skt.project.mvvm.base.BaseResponseBean;
import com.he.skt.project.mvvm.entity.NewsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/5/24
 */
public interface HomeApi {

    @GET("api/information/app")
    Call<BaseResponseBean<NewsData>> getHealthNews(@Query("page") int page, @Query("size") int size);

}
