package com.example.xzr.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SchemeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);

//        Intent forwardIntent = getIntent();
//        String data = forwardIntent.getStringExtra("button_1");


        Button schemeButton = findViewById(R.id.SchemeBtn);
//        schemeButton.setText(data);
        schemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCollector.finishAll();
//                Intent intent =  new Intent();
//                intent.putExtra("schemeActivity_dataReturn","scheme data balabala");
//                setResult(RESULT_OK,intent);
//                finish();
            }
        });


        Button finishBtn = findViewById(R.id.finishBtn);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("scheme activity", "onClick: ");
                ActivityCollector.finishAll();
                finish();
            }
        });

    }


}
