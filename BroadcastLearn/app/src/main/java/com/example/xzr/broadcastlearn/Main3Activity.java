package com.example.xzr.broadcastlearn;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;
    private LocalBroadCastReceiver localBroadCastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        intentFilter = new IntentFilter();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        Button button = findViewById(R.id.main3_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.xzr.broadcastlearn.LocalBroadCastReceiver");
                localBroadcastManager.sendBroadcast(intent);
            }
        });

        intentFilter.addAction("com.example.xzr.broadcastlearn.LocalBroadCastReceiver");
        localBroadCastReceiver = new LocalBroadCastReceiver();
        localBroadcastManager.registerReceiver(localBroadCastReceiver,intentFilter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localBroadCastReceiver);
    }
}
