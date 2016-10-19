package com.example.administrator.sqlitedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.adapter.BookTypesAdapter;
import com.example.administrator.db.BookDBManager;

public class BookMenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lv_bookTypes;
    private BookTypesAdapter adapter;
    private int gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_menu);
        lv_bookTypes = (ListView) findViewById(R.id.lv_bookTypes);
        gender = getIntent().getIntExtra("gender",1);
        adapter = new BookTypesAdapter();
        adapter.setList(BookDBManager.getInstall(this).getBookTypes(gender));
        lv_bookTypes.setAdapter(adapter);
        lv_bookTypes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"点有用没有",Toast.LENGTH_SHORT).show();
        int typeId=adapter.getItem(position).get_id();
        Intent intent=new Intent(BookMenuActivity.this,BookListActivity.class);
        intent.putExtra("typeId", typeId);
        startActivity(intent);
    }
}
