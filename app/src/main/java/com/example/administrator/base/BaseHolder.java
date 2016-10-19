package com.example.administrator.base;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2016/10/12.
 */

public abstract class BaseHolder<T> {
    private View mRootView;
    protected Context context;
    public View getMRootView(){
        return mRootView;
    }

    public BaseHolder(Context context) {
        this.context = context;
        mRootView = initView();
        mRootView.setTag(this);
    }
//初始化佈局
    public abstract View initView();
    //設置屬性到控件，交給子類完成
    public abstract void setData(T t);
}
