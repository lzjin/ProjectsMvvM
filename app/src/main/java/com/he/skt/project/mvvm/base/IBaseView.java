package com.he.skt.project.mvvm.base;

/**
 * Description: 作用描述
 * Author: Administrator
 * CreateDate: 2020/4/7
 */
public interface IBaseView {
    /**
     * 加载中
     */
    void onShowLoading();
    /**
     * 隐藏加载
     */
    void onHideLoading();
    /**
     * Toast消息
     */
    void onShowToast(String toastMessage);
    /**
     * 异常消息
     */
    void onErrorCode(BaseResponseBean bean);
}
