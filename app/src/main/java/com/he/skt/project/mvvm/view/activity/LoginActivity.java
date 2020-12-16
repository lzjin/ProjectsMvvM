package com.he.skt.project.mvvm.view.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.he.skt.project.mvvm.R;
import com.he.skt.project.mvvm.base.BaseResponseBean;
import com.he.skt.project.mvvm.databinding.ActivityLoginBinding;
import com.he.skt.project.mvvm.entity.LoginBean;
import com.he.skt.project.mvvm.utils.MLog;
import com.he.skt.project.mvvm.viewmodel.LoginViewModel;

/**
 * description ： TODO:类的作用
 * author : asus
 * date : 2020/11/16
 */
public class LoginActivity  extends AppCompatActivity {
    private ActivityLoginBinding binding; //xml + Binding
    private LoginViewModel viewmodel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_login);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewmodel=new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(LoginViewModel.class);


        //默认监听 方式一
        binding.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btLogin:
                        login();
                        break;
                }

            }
        });

    }

    /**
     * 登录
     */
    private void login(){
        LoginBean loginVo = new LoginBean();
        viewmodel.login(loginVo).observe(this, new Observer<BaseResponseBean<LoginBean>>() {
            @Override
            public void onChanged(@Nullable BaseResponseBean<LoginBean> loginDtoBaseDto) {
                if(loginDtoBaseDto.getCode()==200){
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this,loginDtoBaseDto.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
