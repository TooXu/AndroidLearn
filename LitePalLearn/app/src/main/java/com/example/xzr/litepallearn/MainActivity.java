package com.example.xzr.litepallearn;

import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建表
        Button creatDatabase = findViewById(R.id.create_table);
        creatDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });

        // 增加数据
        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book oneBook = new Book();
                oneBook.setName("first book");
                oneBook.setAuthor("xzr");
                oneBook.setPages(100);
                oneBook.setPrice(99.99);
                oneBook.setPress("unknow");
                oneBook.save();
            }
        });

        // 更新数据
        Button updateButton = findViewById(R.id.update_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book bookToUpdate = LitePal.find(Book.class,4);
                bookToUpdate.setName("update book");
                bookToUpdate.save();
            }
        });

        // 删除数据
        Button deleteButton = findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.delete(Book.class,3);
                LitePal.deleteAll(Book.class,"id > ?","5");
            }
        });

        Button queryButton = findViewById(R.id.query_button);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> book = LitePal.findAll(Book.class);
                for (Book oneBook : book){
                    Log.i(TAG, "onClick: "+ oneBook.getName());
                }
            }
        });

    }
}
