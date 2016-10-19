package com.example.administrator.holder;

import android.content.Context;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.base.BaseHolder;
import com.example.administrator.db.BookDBManager;
import com.example.administrator.entity.BookLists;
import com.example.administrator.sqlitedemo.R;

/**
 * Created by Administrator on 2016/10/12.
 */

public class BookListsHolder extends BaseHolder<BookLists> {

    private TextView tv_bookName,tv_author,tv_bookType,tv_wordNumber,tv_monthTickets,tv_fans;
    private RatingBar rb_bookStar;
    public BookListsHolder(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.layout_item_booklist,null);
        tv_bookName = (TextView) view.findViewById(R.id.tv_bookName);
        tv_author = (TextView) view.findViewById(R.id.tv_author);
        tv_bookType = (TextView) view.findViewById(R.id.tv_bookType);
        tv_wordNumber = (TextView) view.findViewById(R.id.tv_wordNumber);
        tv_monthTickets = (TextView) view.findViewById(R.id.tv_monthTickets);
        tv_fans = (TextView) view.findViewById(R.id.tv_fans);
        rb_bookStar = (RatingBar) view.findViewById(R.id.rb_bookStar);
        return view;
    }

    @Override
    public void setData(BookLists bookLists) {
        tv_bookName.setText(bookLists.getbookName());
        tv_author.setText(bookLists.getAuthor());

        tv_wordNumber.setText(String.valueOf(bookLists.getWords()));
        tv_monthTickets.setText(String.valueOf(bookLists.getTickets()));
        tv_fans.setText(String.valueOf(bookLists.getfans()));
        tv_bookType.setText(BookDBManager.getInstall(context).getTypeById(bookLists.getTypeId()));
        rb_bookStar.setRating(bookLists.getStar());

    }


}
