package com.example.xzr.databaselearn;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDatabaseHelper(this,"Bookstore.db",null,2);

        // 查数据 query data

        Button queryButton = findViewById(R.id.query_button);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book",null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        int idNum = cursor.getInt(cursor.getColumnIndex("id"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.i(TAG, "onClick: "+idNum);
                        Log.i(TAG, "onClick: "+name);
                        Log.i(TAG, "onClick: "+author);
                        Log.i(TAG, "onClick: "+pages);
                        Log.i(TAG, "onClick: "+price);
                    }while (cursor.moveToNext());

                }
                cursor.close();
            }
        });

        // 创建表
        Button create_table = findViewById(R.id.create_table);
        create_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        // 增加数据 add data
        Button addButton = findViewById(R.id.add_data);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("name","the da Vinci code");
                values.put("author","dan brown");
                values.put("pages",454);
                values.put("price",188);
                db.insert("Book",null,values);
                values.clear();
            }
        });

        // 更新数据 update data
        Button update_button = findViewById(R.id.update_button);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price",10.99);
                db.update("Book",values,"id = ?" , new String[] { "1"});
            }
        });

        // 删除数据 delete data
        Button deleteButton = findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book","id >= ?",new String[]{"3"});
            }
        });

    }
}
