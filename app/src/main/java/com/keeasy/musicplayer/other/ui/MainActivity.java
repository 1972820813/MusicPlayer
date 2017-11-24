package com.keeasy.musicplayer.other.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.keeasy.musicplayer.R;
import com.keeasy.musicplayer.music_list.ui.MusicListFragment;
import com.keeasy.musicplayer.music_message.ui.MusicMessageFragment;
import com.keeasy.musicplayer.music_more.ui.MusicMoreFragment;
import com.keeasy.musicplayer.other.activity.AlarmActivity;
import com.keeasy.musicplayer.other.activity.MemberCenterActivity;
import com.keeasy.musicplayer.other.activity.MyFriendActivity;
import com.keeasy.musicplayer.other.activity.MyMessageActivity;
import com.keeasy.musicplayer.other.activity.OnLineActivity;
import com.keeasy.musicplayer.other.activity.ShoppingActivity;
import com.keeasy.musicplayer.other.util.ActionBarManagerTool;
import com.keeasy.musicplayer.other.util.UrlUtil;
import com.keeasy.musicplayer.other.util.UserInfo;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private static final String TAG = "tag";
    private TextView tvNight, tvSettings, tvExit;//模式.设置.退出
    private DrawerLayout drawer;//侧栏
    private Toolbar toolbar;//导航栏
    private ImageView ivMusicList, ivMusicMore, ivMusicMessage, ivMusicSearch;
    private int lastIndex = 0;//记录最后一个页面
    private Fragment[] fragments;

    /**
     * 侧栏添加头布局
     */
    public View navHeaderView;
    /**
     * 侧栏布局
     */
    private NavigationView navigationView;
    private ImageView ivUserHead;//侧栏用户头像
    private TextView tvUserName;//侧栏用户名字

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //自该状态栏的颜色
        ActionBarManagerTool.initSystemBar(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //设置空字符串
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navHeaderView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        ivUserHead = (ImageView) navHeaderView.findViewById(R.id.nav_iv_user_header);
        Glide.with(this).load(UserInfo.getUserInfo(this).imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(ivUserHead);
        ivUserHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "用户头像", Toast.LENGTH_SHORT).show();
            }
        });
        tvUserName = (TextView) navHeaderView.findViewById(R.id.nav_tv_user_name);
        tvUserName.setText(UserInfo.getUserInfo(this).name);

        navigationView.setNavigationItemSelectedListener(this);
        initViews();
    }

    private void initViews() {
        fragments = new Fragment[]{
                new MusicListFragment(),
                new MusicMoreFragment(),
                new MusicMessageFragment()
        };
        //获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragments.length; i++) {
            Fragment fragment = fragments[i];
            //往指定的布局里添加fragment
            transaction.add(R.id.content_main_fl, fragment);
        //先隐藏起来
        transaction.hide(fragment);
    }
        //默认显示第个
        transaction.show(fragments[0]);
        //提交事务
        transaction.commit();

        ivMusicList = (ImageView) toolbar.findViewById(R.id.app_bar_music_list);
        ivMusicMore = (ImageView) toolbar.findViewById(R.id.app_bar_music_more);
        ivMusicMessage = (ImageView) toolbar.findViewById(R.id.app_bar_music_message);
        ivMusicSearch = (ImageView) toolbar.findViewById(R.id.app_bar_iv_search);
        tvNight = (TextView) findViewById(R.id.main_tv_night);
        tvSettings = (TextView) findViewById(R.id.main_tv_settings);
        tvExit = (TextView) findViewById(R.id.main_exit_drawer);
        ivMusicList.setOnClickListener(this);
        ivMusicMore.setOnClickListener(this);
        ivMusicMessage.setOnClickListener(this);
        ivMusicSearch.setOnClickListener(this);
        tvNight.setOnClickListener(this);
        tvSettings.setOnClickListener(this);
        tvExit.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_message) {
            Toast.makeText(this, "我的消息", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MyMessageActivity.class));
        } else if (id == R.id.nav_member_center) {
            startActivity(new Intent(this,MemberCenterActivity.class));
            Log.d(TAG, "会员中心");
        } else if (id == R.id.nav_shopping) {
            startActivity(new Intent(this,ShoppingActivity.class));
            Log.d(TAG, "商城");
        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(this,OnLineActivity.class));
            Log.d(TAG, "在线听歌免流量");
        } else if (id == R.id.nav_friends) {
            startActivity(new Intent(this,MyFriendActivity.class));
            Toast.makeText(this, "我的好友", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_nearby_people) {
            Toast.makeText(this, "附近的人", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_theme) {
            Toast.makeText(this, "个性皮肤", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_discern) {
            Toast.makeText(this, "听歌识曲", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_timing) {
            Toast.makeText(this, "定时停止播放", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_music_alarm) {
            startActivity(new Intent(this,AlarmActivity.class));
            Log.d(TAG, "音乐闹铃");
        } else if (id == R.id.nav_music_drive) {
            Toast.makeText(this, "驾驶模式", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_music_cloud) {
            Toast.makeText(this, "音乐云盘", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        int index;
        switch (view.getId()) {
            case R.id.app_bar_music_list:
                ivMusicList.setImageResource(R.drawable.t_actionbar_music_selected);
                ivMusicMore.setImageResource(R.drawable.t_actionbar_discover_normal);
                ivMusicMessage.setImageResource(R.drawable.t_actionbar_friends_normal);
                index = 0;
                showFragment(index);
                break;
            case R.id.app_bar_music_more:
                ivMusicList.setImageResource(R.drawable.t_actionbar_music_normal);
                ivMusicMore.setImageResource(R.drawable.t_actionbar_discover_selected);
                ivMusicMessage.setImageResource(R.drawable.t_actionbar_friends_normal);
                index = 1;
                showFragment(index);
                break;
            case R.id.app_bar_music_message:
                ivMusicList.setImageResource(R.drawable.t_actionbar_music_normal);
                ivMusicMore.setImageResource(R.drawable.t_actionbar_discover_normal);
                ivMusicMessage.setImageResource(R.drawable.t_actionbar_friends_selected);
                index = 2;
                showFragment(index);
                break;
            case R.id.app_bar_iv_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;
            case R.id.main_tv_night://侧栏
                Toast.makeText(this, "夜间模式", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_tv_settings://侧栏
                //关闭侧滑栏
                drawer.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.main_exit_drawer://侧栏
                System.exit(0);
                break;
        }
    }

    //显示第几个fragment
    private void showFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //隐藏上一次显示的fragment
        transaction.hide(fragments[lastIndex]);
        //显示选中的fragment
        transaction.show(fragments[index]);
        transaction.commit();
        //记录lastIndex
        lastIndex = index;
    }
}
