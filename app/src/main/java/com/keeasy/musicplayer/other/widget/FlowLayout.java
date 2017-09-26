package com.keeasy.musicplayer.other.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 流式布局
 * Created by LiChenWei on 2017/3/22.
 */

public class FlowLayout extends ViewGroup {
    private List<Text> list = new ArrayList<>();

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        list.clear();

        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = 0, height = 0;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthMeasureSpec;
        } else {
            width = getResources().getDisplayMetrics().widthPixels;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightMeasureSpec;
        } else {
            int sumWidth = 0;
            int maxHeight = 0;
            for (int i = 0; i < getChildCount(); i++) {
                final View child = getChildAt(i);
                MarginLayoutParams params = (MarginLayoutParams) child.getLayoutParams();
                int childWidth = params.leftMargin + params.rightMargin + child.getMeasuredWidth();
                int childHeight = params.topMargin + params.bottomMargin + child.getMeasuredHeight();
                if (sumWidth + childWidth > width) {
                    sumWidth = 0;
                    height += maxHeight;
                    maxHeight = 0;
                }
                Text text = new Text(sumWidth, height, sumWidth + child.getMeasuredWidth(), height + child.getMeasuredHeight());
                list.add(text);

                sumWidth += childWidth;
                maxHeight = Math.max(maxHeight, childHeight);

                if (i == getChildCount() - 1) {
                    height += maxHeight;
                }
            }
            if (height == 0) {
                height = maxHeight;
            }
            //设置宽高
            setMeasuredDimension(width, height);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            Text text = list.get(i);
            child.layout(text.getLeft(), text.getTop(), text.getRight(), text.getBottow());
        }
    }


    //存储text的信息
    public class Text {
        int left, top, right, bottow;

        public Text(int left, int top, int right, int bottow) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottow = bottow;
        }

        public int getBottow() {
            return bottow;
        }

        public void setBottow(int bottow) {
            this.bottow = bottow;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }


    }

    public void setRequestLayout() {
        //再次布局
        requestLayout();
    }

    ;


}
