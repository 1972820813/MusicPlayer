package com.keeasy.musicplayer.music_list.ui;

import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.keeasy.musicplayer.R;
import com.keeasy.musicplayer.music_list.util.PickerScrollView;
import com.keeasy.musicplayer.music_list.util.RecommendPersonalBean;
import com.keeasy.musicplayer.other.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * 音乐列表页面
 * <p>
 * Created by Administrator on 2017/8/1.
 */

public class MusicListFragment extends BaseFragment {

    public static final String TAG = "tag";
    private Button button;

    private List<RecommendPersonalBean> list; // 滚动选择器数据
    private String[] id;
    private String[] name;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_music_list;
    }

    @Override
    protected void initView() {
        button = (Button) root.findViewById(R.id.btn);
        button.setOnClickListener(onClickListener);
    }

    // 点击监听事件
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn) {
                showPopwindow();
            }
        }
    };
    private PickerScrollView scrollView;

    //提示框
    private void showPopwindow() {
        View parent = ((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0);
        View popView = View.inflate(getContext(), R.layout.popwindow_recommend_personal, null);

        scrollView = (PickerScrollView) popView.findViewById(R.id.scroll_view);


        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        final PopupWindow popWindow = new PopupWindow(popView, width, height);
        popWindow.setAnimationStyle(R.style.AnimBottom);
        popWindow.setFocusable(true);
        popWindow.setOutsideTouchable(false);// 设置允许在外点击消失


        // 设置数据，默认选择第一条
        scrollView.setData(list);
        scrollView.setSelected(0);
        scrollView.setOnSelectListener(new PickerScrollView.onSelectListener() {
            @Override
            public void onSelect(RecommendPersonalBean pickers) {
                Toast.makeText(getContext(), "选择：" + pickers.getId() + "--银行："
                        + pickers.getCustomerName(), Toast.LENGTH_SHORT).show();
                popWindow.dismiss();
            }
        });

        ColorDrawable dw = new ColorDrawable(0x30000000);
        popWindow.setBackgroundDrawable(dw);
        popWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    @Override
    protected void initData() {
        list = new ArrayList<RecommendPersonalBean>();
        id = new String[]{"1", "2", "3", "4", "5", "6"};
        name = new String[]{"中国银行", "农业银行", "招商银行", "工商银行", "建设银行", "民生银行"};
        for (int i = 0; i < name.length; i++) {
            RecommendPersonalBean bean = new RecommendPersonalBean();
            bean.setId(id[i]);
            bean.setCustomerName(name[i]);
            list.add(bean);
        }
    }

    @Override
    protected void initEvent() {

    }
}
