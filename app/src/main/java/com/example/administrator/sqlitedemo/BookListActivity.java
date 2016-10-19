package com.example.administrator.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.administrator.adapter.BookListsAdapter;
import com.example.administrator.db.BookDBManager;

public class BookListActivity extends AppCompatActivity {
    private ListView lv_bookList;
    private BookListsAdapter adapter;
    private int typeId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        typeId = getIntent().getIntExtra("typeId",0);
        lv_bookList = (ListView) findViewById(R.id.lv_bookList);
        adapter = new BookListsAdapter();
        adapter.setList(BookDBManager.getInstall(this).getBookLists(typeId));
        lv_bookList.setAdapter(adapter);
    }
}
