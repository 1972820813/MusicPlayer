package com.keeasy.musicplayer.other.adapter;

/**
 * Created by Administrator on 2017/10/25.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.keeasy.musicplayer.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int NORMAL_TYPE = 0;
    private static final int CHECK_TYPE = 1;

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return CHECK_TYPE;
        }
        return NORMAL_TYPE;
    }

    private List<String> data;

    public MyAdapter(List<String> data) {
        this.data = data;
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == NORMAL_TYPE) {
            return new NormalHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal, parent, false));
        } else
            return new CheckHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_check, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NormalHolder) {
            ((NormalHolder) holder).tv_name.setText(data.get(position));
        } else {
            ((CheckHolder) holder).textView.setText(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NormalHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        LinearLayout rootView;

        public NormalHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            rootView = (LinearLayout) itemView.findViewById(R.id.root_view);

        }
    }

    class CheckHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textView;

        public CheckHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.try_study);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(itemView, getAdapterPosition());
            }
        }
    }
}