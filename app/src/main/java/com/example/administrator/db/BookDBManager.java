package com.example.administrator.db;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.administrator.entity.BookLists;
import com.example.administrator.entity.BookTypes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */

public class BookDBManager {
    MyOpenHelper helper;
    private static BookDBManager bookDBManager;

    private BookDBManager(Context context) {
        helper = new MyOpenHelper(context);
    }
    public static BookDBManager getInstall(Context context){
        if (bookDBManager ==null){
            bookDBManager = new BookDBManager(context);
        }
        return bookDBManager;
    }
    public static void resetDB(Context context) {
        String path = Environment.getDataDirectory() + "/data/" + context.getPackageName() + "/databases/book.db";
        SQLiteDatabase.deleteDatabase(new File(path));
    }
    public List<BookTypes> getBookTypes(int gender){
        List<BookTypes> list = new ArrayList<>();
        String sql = "select * from "+MyOpenHelper.BOOK_TYPES+" where gender = '"+gender+"'";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String type = cursor.getString(cursor.getColumnIndex("type"));
            list.add(new BookTypes(_id,type,gender));
        }
        cursor.close();
        db.close();
        return list;
    }
    public List<BookLists> getBookLists(int typeId){
        List<BookLists> books = new ArrayList<>();
        String sql = "select * from "+ MyOpenHelper.BOOK_LISTS + " where typeId = '"+ typeId + "'";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            String bookName = cursor.getString(cursor.getColumnIndex("bookName"));
            String author = cursor.getString(cursor.getColumnIndex("author"));
            int star = cursor.getInt(cursor.getColumnIndex("star"));
            int words = cursor.getInt(cursor.getColumnIndex("words"));
            int tickets = cursor.getInt(cursor.getColumnIndex("tickets"));
            int fans = cursor.getInt(cursor.getColumnIndex("fans"));
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));

            BookLists bookList = new BookLists(bookName,author,star,words,tickets,fans);
            bookList.set_id(_id);
            bookList.setTypeId(typeId);
            books.add(bookList);

        }
        cursor.close();
        db.close();
        return books;
    }
    public String getTypeById(int typeId){
        String sql = "select type from " + MyOpenHelper.BOOK_TYPES +" where _id ='"+ typeId +"'";
        Cursor cursor = helper.getReadableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()){
            return cursor.getString(cursor.getColumnIndex("type"));
        }
        return null;
    }
}
