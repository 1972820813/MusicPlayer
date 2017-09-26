package com.keeasy.musicplayer.music_more.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.keeasy.musicplayer.R;
import com.keeasy.musicplayer.music_more.adapter.ViewPagerAdapter;
import com.keeasy.musicplayer.other.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 更多音乐页面
 * <p>
 * Created by Administrator on 2017/8/1.
 */
public class MusicMoreFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> fragmentList;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_music_more;
    }

    @Override
    protected void initView() {
        fragmentList = new ArrayList<>();
        tabLayout = (TabLayout) root.findViewById(R.id.more_tl_tabLayout);
        viewPager = (ViewPager) root.findViewById(R.id.more_tl_view_pager);
    }

    @Override
    protected void initData() {

        fragmentList.add(new RecommendFragment());
        fragmentList.add(new SongListFragment());
        fragmentList.add(new BroadcastLiveFragment());
        fragmentList.add(new RankListFragment());
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),fragmentList);
        viewPager.setAdapter(viewPagerAdapter);


        tabLayout.addTab(tabLayout.newTab().setText("个性推荐"));
        tabLayout.addTab(tabLayout.newTab().setText("歌单"));
        tabLayout.addTab(tabLayout.newTab().setText("主播电台"));
        tabLayout.addTab(tabLayout.newTab().setText("排行榜"));
    }

    @Override
    protected void initEvent() {
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
}
