package com.example.administrator.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    protected List<T> list;
    private List<T> mlist;


    public MyBaseAdapter() {
        list = new ArrayList<>();
    }

    public MyBaseAdapter(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getMlist() {
        return mlist;
    }

    public void setMlist(List<T> mlist) {
        this.mlist = mlist;
    }

    public void addData(T t){
        if (list ==null){
            return;
        }
        list.add(t);
    }
    public void removeData(T t){
        if (list == null){
            return;
        }
        list.remove(t);
    }
    public void addListData(List<T> mlist){
        list.addAll(mlist);
    }
    public void removeListData(List<T> mlist){
        list.removeAll(mlist);
    }
    public void clear(){
        if (list == null){
            return;
        }
        list.clear();
    }
    @Override
    public int getCount() {
        return list == null?0:list.size();
    }

    @Override
    public T getItem(int position) {
        return list == null?null:list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder<T> holder = null;
        if (convertView == null){
            holder = getHolder(parent.getContext());
            convertView = holder.getMRootView();
        }else {
            holder = (BaseHolder<T>) convertView.getTag();
        }
        //修改數據
        holder.setData(getItem(position));

        return convertView;
    }

    public abstract BaseHolder<T> getHolder(Context context);
}
