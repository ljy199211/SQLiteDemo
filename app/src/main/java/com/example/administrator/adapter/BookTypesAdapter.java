package com.example.administrator.adapter;

import android.content.Context;

import com.example.administrator.base.BaseHolder;
import com.example.administrator.base.MyBaseAdapter;
import com.example.administrator.entity.BookTypes;
import com.example.administrator.holder.BookTypesHolder;

/**
 * Created by Administrator on 2016/10/12.
 */

public class BookTypesAdapter extends MyBaseAdapter<BookTypes> {
    @Override
    public BaseHolder getHolder(Context context) {
        return new BookTypesHolder(context);
    }
}
