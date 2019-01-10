package com.example.xzr.broadcastlearn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by xzr on 2018/12/28.
 */

class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"network changes",Toast.LENGTH_SHORT).show();
    }
}
