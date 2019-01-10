package com.example.xzr.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent newIntent = getIntent();
        String getStringFromFirst = newIntent.getStringExtra("extra_data");
        Log.i(TAG,"new string = " + getStringFromFirst);

        setContentView(R.layout.second_layout);

        final Button button_2 = (Button) findViewById(R.id.button_2);

        TextView intentText = (TextView) findViewById(R.id.intent_text);
        intentText.setText(getStringFromFirst);
        // 要启动的组件名称
        // 这是可选项，但也是构建显式 Intent 的一项重要信息，
        // 这意味着 Intent 应当仅传递给由组件名称定义的应用组件。
        // 如果没有组件名称，则 Intent 是隐式的，
        button_2.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,FirstActivity.class);
//                Intent intent = new Intent("com.example.xzr.activitytest.ACTION_START");
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");

                Log.i(TAG, "onClick: category"+ i++);
                button_2.setText(""+i++);
                startActivity(intent);
            }
        });

        Button telButton = (Button)findViewById(R.id.telButton);
        telButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, v.toString());
                // 操作
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        // dealloc button
        Button deallocBtn = (Button)findViewById(R.id.deallocButton);

        deallocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// 显示 intent
                Intent intent = new Intent(SecondActivity.this,SchemeActivity.class);
                startActivity(intent);

//                Toast.makeText(SecondActivity.this,"dealloc btn click",Toast.LENGTH_LONG).show();
//                finish();
            }
        });


    }


    // 创建 menu button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    // menu button 点击方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this,"add item ",Toast.LENGTH_SHORT).show();
                break;

            case  R.id.remove_item:
                Toast.makeText(this,"remove item",Toast.LENGTH_LONG).show();
                break;
                default:

        }

        return true;
    }
}
