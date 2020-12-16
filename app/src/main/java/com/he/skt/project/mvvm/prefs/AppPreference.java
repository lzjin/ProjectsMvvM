package com.he.skt.project.mvvm.prefs;

import android.content.Context;
import android.content.SharedPreferences;


import com.he.skt.project.mvvm.contants.AppConstant;

import java.util.Map;

/**
 * Description: 缓存 先在app初始化再使用
 * Author: Lzj
 * CreateDate: 2020/5/24
 */
public class AppPreference {
    private static AppPreference instance = null;
    private static SharedPreferences preferences = null;
    private static SharedPreferences.Editor editor = null;
    //优先初始化
    public static void init(Context context) {
        instance = new AppPreference();
        preferences = context.getSharedPreferences(AppConstant.SP_APP_DATA_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static AppPreference getInstance() {
        return instance;
    }

    /**
     * 向SP存入指定key对应的数据
     */
    public static void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public static void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public static void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public static void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * 获取SP数据里指定key对应的value。如果key不存在，则返回默认值defValue。
     */
    public static String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public static float getFloat(String key, float defValue) {
        return preferences.getFloat(key, defValue);
    }

    public static int getInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public static long getLong(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }



    /**
     * 删除SP里指定key对应的数据项
     */
    public static void remove(String key) {
        editor.remove(key);
        editor.commit();
    }
    /**
     * 查询指定key是否存在
     */
    public static  boolean contains(String key) {
        return preferences.contains(key);
    }

    /**
     * 返回所有的键值对
     */
    public static Map<String, ?> getAll() {
        return preferences.getAll();
    }
    /**
     * 清空SP里所以数据
     */
    public static void clearAll() {
        editor.clear();
        editor.commit();
    }
}
