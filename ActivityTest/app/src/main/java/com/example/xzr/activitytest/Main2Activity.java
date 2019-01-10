package com.example.xzr.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView main2text = findViewById(R.id.main2text);

        Intent intent = getIntent();
        String data = intent.getStringExtra("mainExtra");
        main2text.setText(data);

        Button button = findViewById(R.id.goBackBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent();
                backIntent.putExtra("main2Extra","this is a string from main2 activity");
                setResult(RESULT_OK,backIntent);
                finish();
            }
        });

    }
}
