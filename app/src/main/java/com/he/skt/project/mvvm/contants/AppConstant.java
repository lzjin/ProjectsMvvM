package com.he.skt.project.mvvm.contants;

import android.os.Environment;

/**
 * Description: App常量池
 * Author: Administrator
 * CreateDate: 2020/4/7
 */
public class AppConstant {
    public static final String APP_ROOT_PATH= Environment.getExternalStorageDirectory().getAbsolutePath()+"/AA_test/";//根路径
    public static final String IMA_PATH= APP_ROOT_PATH+"/user_images/";//图片
    public static final String DOWNLOAD_APK_PATH=APP_ROOT_PATH+"/download";//下载路径
    public static final String SAVE_DATA_NAME = "SavaData";


    public static final String SP_IS_Frist = "isFrist";
    public static final String SP_COOKIES = "cookies";
    public static final String SP_VERSION_CODE = "version_code";//版本，判断是否进入引导

    public static final String SP_APP_DATA_NAME = "app_info";
    public static final String SP_USER_DATA_NAME = "user_info";

    public static final String SP_BASE_TOKEN = "Basic dGFpamk6dGFpamlzZWNyZXQ=";
    public static final String SP_TOKEN = "token";
    public static final String SP_REFRESHTOKEN = "refreshToken";
}
