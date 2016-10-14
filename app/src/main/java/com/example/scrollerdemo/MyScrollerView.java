package com.example.scrollerdemo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by liuyuan on 2016/10/13 0013.
 */
public class MyScrollerView extends ViewGroup {
    private Scroller mScroller;
    public MyScrollerView(Context context) {
        this(context, null);
    }

    private void initView() {
        mScroller=new Scroller(getContext());
        LinearLayout first=new LinearLayout(getContext());
        first.setBackgroundColor(Color.RED);
        addView(first);
        LinearLayout second=new LinearLayout(getContext());
        second.setBackgroundColor(Color.BLUE);
        addView(second);
        LinearLayout three=new LinearLayout(getContext());
        three.setBackgroundColor(Color.YELLOW);
        addView(three);
    }

    public MyScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
    }
}
