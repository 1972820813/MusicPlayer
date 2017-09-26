package com.keeasy.musicplayer.other.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.keeasy.musicplayer.other.bean.UserBean;

/**
 *  存储用户信息
 * Created by Administrator on 2017/8/11.
 */

public class UserInfo {
    public static void saveUserInfo(UserBean user, Context context, boolean fsg) {
        SharedPreferences mySharedPreferences = context.getSharedPreferences(
                "user", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString("userId", user.getUserId());
        if (fsg) {
            editor.putString("password", user.getPassword());
        }
        user.setImageUrl(UrlUtil.IMAGE_URL_1);
        user.setName("伪装者");
        user.setMobile("18688756634");
        editor.putString("name", user.getName());
        editor.putString("mobile", user.getMobile());
        editor.putString("imageUrl", user.getImageUrl());
        editor.commit();
    }

    public static UserBean getUserInfo(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("user", Activity.MODE_PRIVATE);
        UserBean user = new UserBean();
        user.userId = sharedPreferences.getString("userId", null);
        user.password = sharedPreferences.getString("password", "");
        user.name = sharedPreferences.getString("name", "");
        user.mobile = sharedPreferences.getString("mobile", null);
        user.imageUrl = sharedPreferences.getString("imageUrl", "");
        return user;
    }
}
