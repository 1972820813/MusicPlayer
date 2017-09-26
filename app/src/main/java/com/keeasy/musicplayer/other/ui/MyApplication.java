package com.keeasy.musicplayer.other.ui;

import android.app.Application;
import android.content.Context;

import com.keeasy.musicplayer.other.bean.UserBean;
import com.keeasy.musicplayer.other.util.UserInfo;

/**
 * Created by Administrator on 2017/8/17.
 */

public class MyApplication extends Application {

    public static Context context;

    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        UserInfo.saveUserInfo(new UserBean(), context, true);

    }

}

