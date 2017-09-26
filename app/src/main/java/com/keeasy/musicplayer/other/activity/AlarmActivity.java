package com.keeasy.musicplayer.other.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.keeasy.musicplayer.R;

import java.util.Calendar;

/**
 * 音乐闹铃
 * Created by Administrator on 2017/8/7.
 */

public class AlarmActivity extends AppCompatActivity  implements View.OnClickListener{

    private ImageView ivBack;//返回键
    private RelativeLayout rlAlarmLayoutAgain,rlAlarmLayoutSing;
    private TextView tvTime;

    private ImageView ivAlarmOn,ivAlarmAgain;

    private boolean onBoolean = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        initViews();
    }

    private void initViews() {

        tvTime = (TextView) findViewById(R.id.alarm_tv_time);
        ivBack = (ImageView) findViewById(R.id.alarm_title_back);
        rlAlarmLayoutSing = (RelativeLayout) findViewById(R.id.alarm_rl_sing);
        rlAlarmLayoutAgain = (RelativeLayout) findViewById(R.id.alarm_rl_again);
        ivAlarmOn = (ImageView) findViewById(R.id.alarm_iv_on);
        ivAlarmAgain = (ImageView) findViewById(R.id.alarm_iv_again_on);

        tvTime.setOnClickListener(this);
        ivAlarmOn.setOnClickListener(this);
        rlAlarmLayoutSing.setOnClickListener(this);
        rlAlarmLayoutAgain.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alarm_tv_time:
                Toast.makeText(this, "选择时间", Toast.LENGTH_SHORT).show();
                break;
            case R.id.alarm_iv_on:

                if(onBoolean){
                    ivAlarmOn.setImageResource(R.drawable.togglebutton_on);
                    onBoolean = !onBoolean;
                }else{
                    ivAlarmOn.setImageResource(R.drawable.togglebutton_off);
                    onBoolean = !onBoolean;
                }
                Toast.makeText(this, "开启闹铃", Toast.LENGTH_SHORT).show();
                break;
            case R.id.alarm_rl_again:
            case R.id.alarm_iv_again_on:
                Toast.makeText(this, "选择重复日期", Toast.LENGTH_SHORT).show();
                break;


            case R.id.alarm_title_back:
                finish();
                break;
        }
    }






}
