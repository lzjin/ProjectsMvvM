package com.he.skt.project.mvvm.utils;

import android.util.Log;

/**
 * Created by Administrator on 2017/3/22.
 * 日志打印
 */
public class MLog {

    public static boolean isShowLogo = true;

    private static final String TAG = "testz";

    public static void i(String message) {
        if(isShowLogo) Log.i(TAG, "--------------"+message);
    }

    public static void d(String message) {
        if(isShowLogo) Log.d(TAG, "--------------"+message);
    }

    public static void e(String message) {
        if(isShowLogo) Log.e(TAG, "--------------"+message);
    }

}
