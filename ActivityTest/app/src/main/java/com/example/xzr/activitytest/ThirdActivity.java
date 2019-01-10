package com.example.xzr.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button thirdBtn = (Button) findViewById(R.id.ThirdButton);
        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        final Intent intent = getIntent();
        String data = intent.getStringExtra("remove_data");
        Log.i(TAG, "onCreate: "+ data);

        thirdBtn.setText(""+data);

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent();
                newIntent.putExtra("data_return","this is thirdActivity");
                setResult(RESULT_OK,newIntent);
                finish();
            }
        });

    }
}
