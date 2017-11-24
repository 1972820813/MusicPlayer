package com.keeasy.musicplayer.other.activity;

import android.content.Intent;
import android.media.projection.MediaProjection;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.keeasy.musicplayer.R;
import com.keeasy.musicplayer.other.adapter.MyAdapter;
import com.keeasy.musicplayer.other.widget.MediaRecordService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */

public class MyMessageActivity  extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initData();
        initView();
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("hunao " + i);
        }
}

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MyMessageActivity.this, "重新学习", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
