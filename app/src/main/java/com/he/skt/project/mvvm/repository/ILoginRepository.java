package com.he.skt.project.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.he.skt.project.mvvm.base.BaseResponseBean;
import com.he.skt.project.mvvm.entity.LoginBean;

/**
 * description ： TODO:类的作用
 * author : asus
 * date : 2020/11/16
 */
public interface ILoginRepository {
    /**
     * 登录
     * @param loginVo
     * @return
     */
    LiveData<BaseResponseBean<LoginBean>> login(LoginBean loginVo);

}
