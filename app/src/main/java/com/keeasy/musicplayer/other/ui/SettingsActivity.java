package com.keeasy.musicplayer.other.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.CookieManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.keeasy.musicplayer.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 设置界面
 * Created by smile on 2017/2/17.
 */

public class SettingsActivity extends AppCompatActivity {
    //设置页面的  返回键
    private ImageView ivBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_settings);

        ivBack = (ImageView) findViewById(R.id.setting_iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}