package com.example.scrollerdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by liuyuan on 2016/10/14 0014.
 */
public class MyViewGroup extends ViewGroup {
    private final String TAG=this.getClass().getSimpleName();
    private Scroller mScorller;
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScorller=new Scroller(context);
    }

    @Override
    protected void onLayout(boolean b, int left, int top, int right, int bottom) {
        Log.e(TAG, "left===" + left + "top==" + top + "right==" + right + "bottom==" + bottom);

        int childSize=getChildCount();
        for(int i=0;i<childSize;i++){
            View childView = getChildAt(i);
            childView.layout(left,top,left+100,top+100);
            Log.e(TAG, "leftchild" +childView.getLeft() + "topchild==" + childView.getTop() + "rightchild==" + childView.getRight() + "bottomchild==" + childView.getBottom());
            left=left+100;
        }
    }
    public void startMove(){
        mScorller.startScroll(0,0,getChildCount()*100,0,3000);
        invalidate();
    }

    @Override
    public void computeScroll() {
         if(mScorller.computeScrollOffset()){
             scrollTo(mScorller.getCurrX(),mScorller.getCurrY());
             postInvalidate();
         }
    }
}
