package com.example.xzr.broadcastlearn;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;
    private LocalBroadCastReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        Button button = findViewById(R.id.main2_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.xzr.broadcastlearn.LOCALCAST");

                localBroadcastManager.sendBroadcast(intent);
                Intent jumpIntent = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(jumpIntent);
            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.xzr.broadcastlearn.LOCALCAST");
        localReceiver = new LocalBroadCastReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }
}
