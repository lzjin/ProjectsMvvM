package com.he.skt.project.mvvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.he.skt.project.mvvm.databinding.ActivityLoginBinding;
import com.he.skt.project.mvvm.view.activity.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Intent intent=new Intent(this, LoginActivity.class);
       // startActivity(intent);
        initBotView();
    }

    private void initBotView() {
        bottomNavigationView=findViewById(R.id.ma_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                       // viewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_two:
                       // viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_cet:
                       // viewPager.setCurrentItem(2);
                        return true;
                    case R.id.navigation_shop:
                       // viewPager.setCurrentItem(3);
                        return true;
                    case R.id.navigation_mine:
                       // viewPager.setCurrentItem(4);
                        return true;
                }
                return false;
            }
        });

    }
}
