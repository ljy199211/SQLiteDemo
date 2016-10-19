package com.example.administrator.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/12.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String[] BOY_LIST = {"玄幻", "奇幻", "仙侠", "武侠", "都市", "职场", "历史", "军事", "游戏", "体育", "科幻", "灵异",
            "二次元", "短篇"};
    private static final String[] GIRL_LIST = {"古代言情", "现代言情", "玄幻言情", "悬疑灵异", "浪漫青春", "仙侠奇缘", "科幻空间", "游戏竞技"};

    public MyOpenHelper(Context context) {
        super(context, "book.db", null, 1);
        getReadableDatabase();
    }
    public static final String CREATE_BOOK_TYPES = "create table bookTypes(_id Integer primary key not null,type varchar(11),gender int(2))";
    public static final String CREATE_BOOK_LISTS = "create table bookLists(_id Integer primary key not null,typeId Integer not null,bookName varchar(11),author varchar(11),star Integer,words Integer,tickets Integer,fans Integer)";
    public static final String BOOK_TYPES = "bookTypes";
    public static final String BOOK_LISTS = "bookLists";
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_BOOK_TYPES);

        db.execSQL(CREATE_BOOK_LISTS);
        initBookTypes(db);
        initBookLists(db);
    }

    private String[][] bookInfo = {BOY_LIST, GIRL_LIST};

    private void initBookLists(SQLiteDatabase db) {
        for (int i = 0; i < bookInfo.length; i++) {
            for (int j = 0; j < bookInfo[i].length; j++) {
                for (int l = 0; l < 10; l++) {
                    String bookName = bookInfo[i][j] + l;
                    String author = "author" + l;
                    int typeId = i == 0 ? j + 1 : j + 15;
                    int star = (int) (Math.random()*5);
                    int words = (int)(Math.random()*10000);
                    int tickets = (int)(Math.random()*1000);
                    int fans = (int)(Math.random()*10000);

                    ContentValues values = new ContentValues();
                    values.put("bookName",bookName);
                    values.put("author",author);
                    values.put("typeId",typeId);
                    values.put("star",star);
                    values.put("words",words);
                    values.put("tickets",tickets);
                    values.put("fans",fans);
                    db.insert(BOOK_LISTS,null,values);
                }
            }
        }
    }

    private void initBookTypes(SQLiteDatabase db) {
        for (String string:BOY_LIST){
            ContentValues values = new ContentValues();
            values.put("gender","1");
            values.put("type",string);
            db.insert(BOOK_TYPES,null,values);
        }
        for (String string:GIRL_LIST){
            ContentValues values = new ContentValues();
            values.put("gender","0");
            values.put("type",string);
            db.insert(BOOK_TYPES,null,values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
