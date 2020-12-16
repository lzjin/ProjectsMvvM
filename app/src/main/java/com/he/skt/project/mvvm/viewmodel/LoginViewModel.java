package com.he.skt.project.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.he.skt.project.mvvm.base.BaseResponseBean;
import com.he.skt.project.mvvm.entity.LoginBean;
import com.he.skt.project.mvvm.repository.ILoginRepository;
import com.he.skt.project.mvvm.repository.LoginRepository;

/**
 * description ： TODO:类的作用
 * author : asus
 * date : 2020/11/16
 */
public class LoginViewModel extends ViewModel {
    /**
     *  登录
     * @param loginVo
     * @return
     */
    public LiveData<BaseResponseBean<LoginBean>> login(LoginBean loginVo){
        ILoginRepository loginRepository = new LoginRepository();
        return loginRepository.login(loginVo);
    }

}
