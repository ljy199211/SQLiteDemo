package com.example.administrator.adapter;

import android.content.Context;

import com.example.administrator.base.BaseHolder;
import com.example.administrator.base.MyBaseAdapter;
import com.example.administrator.entity.BookLists;
import com.example.administrator.holder.BookListsHolder;

/**
 * Created by Administrator on 2016/10/12.
 */

public class BookListsAdapter extends MyBaseAdapter<BookLists> {
    @Override
    public BaseHolder getHolder(Context context) {
        return new BookListsHolder(context);
    }
}
