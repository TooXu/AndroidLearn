package com.example.xzr.broadcastlearn2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"receive in anotherBroadcastReceiver",Toast.LENGTH_LONG).show();
    }
}
