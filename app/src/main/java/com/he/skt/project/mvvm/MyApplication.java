package com.he.skt.project.mvvm;

import android.app.Application;
import android.content.Context;

import com.he.skt.project.mvvm.https.HttpRetrofit;
import com.he.skt.project.mvvm.prefs.AppPreference;

/**
 * Description: 作用描述
 * Author: Administrator
 * CreateDate: 2020/4/7
 */
public class MyApplication extends Application {
    private static Context context;
    public  static MyApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        MyApplication.context = getApplicationContext();
        initRetrofitUtil();
        AppPreference.init(this);
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }

    private void initRetrofitUtil() {
         new HttpRetrofit(getAppContext());
    }

}
