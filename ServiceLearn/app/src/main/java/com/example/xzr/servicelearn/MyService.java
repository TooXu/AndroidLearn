package com.example.xzr.servicelearn;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    private DownloadBinder mBinder = new DownloadBinder();

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
    }
    // 服务一旦启动就立刻去执行某个动作
    // 每次 startService 都会执行
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    // 获取一个服务的持久链接,这时就会回调服务中的 onBind()方法. 调用方可以获取返回的 IBinder 对象
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.i(TAG, "startDownload: ");
        }
        public int getProgress() {
            Log.i(TAG, "getProgress: ");
            return 0;
        }
    }
}
