package com.he.skt.project.mvvm.repository;

import com.he.skt.project.mvvm.base.BaseObserver;
import com.he.skt.project.mvvm.base.BaseResponseBean;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

/**
 * description ： TODO:类的作用
 * author : asus
 * date : 2020/11/16
 */
public class BaseRepository {
    /**
     * 请求网络
     * @param flowable
     * @param <T>
     * @return
     */
    public <T> BaseObserver<T> request(Flowable<BaseResponseBean<T>> flowable){
//        BaseObserver<T> baseHttpSubscriber = new BaseObserver<>(); //RxJava Subscriber回调
//        flowable.subscribeOn(Schedulers.io()) //解决背压
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(baseHttpSubscriber);
//        return baseHttpSubscriber;

        return null;
    }

}
