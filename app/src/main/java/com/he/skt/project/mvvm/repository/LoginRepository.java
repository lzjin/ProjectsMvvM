package com.he.skt.project.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.he.skt.project.mvvm.base.BaseResponseBean;
import com.he.skt.project.mvvm.entity.LoginBean;
import com.he.skt.project.mvvm.https.HttpRetrofit;

/**
 * description ： TODO:类的作用
 * author : asus
 * date : 2020/11/16
 */
public class LoginRepository extends BaseRepository implements ILoginRepository  {
    @Override
    public LiveData<BaseResponseBean<LoginBean>> login(LoginBean loginVo) {
         //return request(HttpRetrofit.getInstance(ApiService.class).login(loginVo)).get();
        return null;
    }
}
