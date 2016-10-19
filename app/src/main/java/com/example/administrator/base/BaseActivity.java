package com.example.administrator.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */

public class BaseActivity extends Activity {
    private static List<BaseActivity> activities = new ArrayList<>();
    public void finishAll(){
        Iterator<BaseActivity> iterator = activities.iterator();
        while (iterator.hasNext()){
            iterator.next().finish();
        }
    }
    public void jumpTo(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
    public void jumpTo(Class<?> cls,Bundle bundle){
        Intent intent = new Intent(this,cls);
        if (bundle !=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    public void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        activities.remove(this);
    }


}
