package com.keeasy.musicplayer.other.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.keeasy.musicplayer.R;
import com.keeasy.musicplayer.other.adapter.FriendViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的好友
 * Created by Administrator on 2017/8/7.
 */

public class MyFriendActivity extends AppCompatActivity implements View.OnClickListener{
    private TabLayout tabLayout;
    private List<Fragment> fragmentList;
    private FriendViewPagerAdapter adapter;
private ImageView ivBack;

    private ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        initView();

        initData();
    }

    private void initView() {
        fragmentList = new ArrayList<>();
        ivBack = (ImageView) findViewById(R.id.friend_title_back);
        ivBack.setOnClickListener(this);
        viewPager = (ViewPager) findViewById(R.id.friend_vp);
        tabLayout = (TabLayout) findViewById(R.id.friend_tb);
        tabLayout.addTab(tabLayout.newTab().setText("关注"));
        tabLayout.addTab(tabLayout.newTab().setText("粉丝"));
    }

    private void initData() {
        fragmentList.add(new AttentionFragment());
        fragmentList.add(new FansFragment());
        adapter = new FriendViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);

        // 监听ViewPager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position % fragmentList.size()).select();
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        /**
         * 监听TabLayout，使ViewPager跟着一起移动
         */
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.friend_title_back:
                finish();
                break;
        }
    }
}
