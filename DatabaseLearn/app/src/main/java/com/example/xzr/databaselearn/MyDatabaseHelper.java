package com.example.xzr.databaselearn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by xzr on 2019/1/4.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String Create_book = "create table Book ("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price integer,"
            + "pages integer,"
            + "name text)";

    public static final String Create_Category = "create table Category ("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";

    private Context mContext;
    
    
    public MyDatabaseHelper(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_book);
        db.execSQL(Create_Category);
        Toast.makeText(mContext, "create table", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
