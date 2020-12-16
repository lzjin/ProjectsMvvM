package com.he.skt.project.mvvm.contants;

/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/5/24
 */
public interface HttpConstant {

    //String BASE_URL = "http://192.168.10.90:8090/";//68
    String BASE_URL = "https://test.ougo.ltd/";//线上
    // String BASE_URL = "https://ougo.natapp4.cc/"; // http://ougo2.natapp1.cc/  //本地内网
    // String BASE_URL = "http://192.168.0.132:8091/";
    // String BASE_URL = "https://shop.tjdyf.cn/";

    String BASE_URL2 = "http://www.danqiuedu.com/";//接口生产环境

    //String HOME_URL="http://101.132.172.106/";
    String HOME_URL="https://tj.news.ougo.ltd/";

    //请求成功
    int RESPONSE_SUCCESS = 200;
    String URL_LOGIN = BASE_URL + "v2/signin_check";//登录
    String URL_IS_REGISTERED = BASE_URL + "v2/registered";//验证手机号是否注册
    String APP_HEAD = "taiji-app";



}
