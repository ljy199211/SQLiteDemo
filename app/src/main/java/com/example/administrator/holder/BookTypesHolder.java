package com.example.administrator.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.base.BaseHolder;
import com.example.administrator.entity.BookTypes;
import com.example.administrator.sqlitedemo.R;

/**
 * Created by Administrator on 2016/10/12.
 */

public class BookTypesHolder extends BaseHolder<BookTypes> {
    private TextView tv_menu_bookType;

    public BookTypesHolder(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.layout_item_bookmenu,null);
        tv_menu_bookType = (TextView) view.findViewById(R.id.tv_menu_bookType);
        return view;
    }

    @Override
    public void setData(BookTypes bookTypes) {
        tv_menu_bookType.setText(bookTypes.getType());
    }
}
