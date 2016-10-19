package com.example.administrator.sqlitedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_boy, R.id.btn_girl})
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,BookMenuActivity.class);
        switch (view.getId()) {
            case R.id.btn_boy:
                intent.putExtra("gender",1);
                break;
            case R.id.btn_girl:
                intent.putExtra("gender",0);
                break;
        }
        startActivity(intent);
    }
}

