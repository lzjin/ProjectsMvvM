package com.he.skt.project.mvvm.prefs;

import android.content.Context;
import android.content.SharedPreferences;


import com.he.skt.project.mvvm.contants.AppConstant;
import com.he.skt.project.mvvm.entity.UserBean;

import java.util.Map;

/**
 * Description: 用户信息
 * Author: Lzj
 * CreateDate: 2020/5/24
 */
public class UserPreference {
    private static UserPreference instance = null;
    private static SharedPreferences preferences = null;
    private static SharedPreferences.Editor editor = null;
    //优先初始化
    public static void init(Context context) {
        instance = new UserPreference();
        preferences = context.getSharedPreferences(AppConstant.SP_USER_DATA_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static UserPreference getInstance() {
        return instance;
    }

    /**
     * 向SP存入指定key对应的数据
     */
    /**
     * 写入
     */
    public static void put(String key, Object value) {
//        SharedPreferences.Editor edit = getSP(context).edit();
//        if (value instanceof Integer) {
//            edit.putInt(key, (Integer) value);
//        } else if (value instanceof String) {
//            edit.putString(key, (String) value);
//        } else if (value instanceof Boolean) {
//            edit.putBoolean(key, (Boolean) value);
//        } else if (value instanceof Long) {
//            edit.putLong(key, (Long) value);
//        } else if (value instanceof Float) {
//            edit.putFloat(key, (Float) value);
//        }
//        edit.apply();
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

    public static void saveUserInfo(Context context, UserBean user) {
//        UserPreference.put(context, SPConstant.SP_USER_ID, user.getId());//登录成功保存id和店铺id
//        UserPreference.put(context, SPConstant.SP_SHOP_ID, user.getShopId());
//        UserPreference.put(context, SPConstant.SP_USER_TYPE, user.getType());//更新用户类型
//        UserPreference.put(context, SPConstant.HAS_BASE_TEST, user.isHasProfile());
//        UserPreference.put(context, SPConstant.SP_HAS_PWD, user.isHasPwd());//写入是否含有密码
//        UserPreference.put(context, SPConstant.SP_PHONE, user.getPhone());//保存手机号
//        if (TextUtils.isEmpty(user.getType())) {//如果没有type设置为默认
//            user.setType(UserConstant.DEFAULT);
//        }
//        SPUtil.put(context, SPConstant.SP_USER_TYPE, user.getType());
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
