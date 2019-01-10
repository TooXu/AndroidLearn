package com.example.xzr.broadcastlearn;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        Button button = findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent("com.example.broadcastlearn.MY_BROADCAST");
//                intent.putExtra("msg","这是一条标准广播 他是静态广播");
//                // android 8.0 后需要制定包名与接收器路径
//                intent.setComponent(new ComponentName("com.example.xzr.broadcastlearn","com.example.xzr.broadcastlearn.MyBroadcastReceiver"));
////                intent.setComponent(new ComponentName("com.example.xzr.broadcastlearn2","com.example.xzr.broadcastlearn2.AnotherBroadCastReceiver"));
//                sendOrderedBroadcast(intent,null);

//                Intent intent = new Intent("com.example.xzr.broadcastlearn.LOCAL_BROADCAST");
//                localBroadcastManager.sendBroadcast(intent);


                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("com.example.xzr.broadcastlearn.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
//        intentFilter.addAction("com.example.broadcastteset.LOCAL");
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);

        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    private class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"local receiver ",Toast.LENGTH_LONG).show();
        }
    }
}
