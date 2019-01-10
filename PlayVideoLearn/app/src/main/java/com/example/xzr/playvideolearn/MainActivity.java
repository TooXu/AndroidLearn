package com.example.xzr.playvideolearn;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private VideoView videoView;
    private static final String TAG = "MainActivity";
    private String url2 = "http://qiubai-video.qiushibaike.com/YXSKWQA6N838MJC4_3g.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.video_view);

        Button playBtn = findViewById(R.id.play);
        Button pauseBtn = findViewById(R.id.pause);
        Button stopBtn = findViewById(R.id.replay);

        playBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else  {
            initVideoPath();
        }
    }

    private void initVideoPath() {
//        File file = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS),"jojo.mp4");
//        Uri sharedFileUri = FileProvider.getUriForFile(this, "com.example.xzr.playvideolearn.fileprovider", file);


        Log.i(TAG, "initMediaPlayer: "+ Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).toString());
//        videoView.setVideoPath(file.getPath());
        videoView.setVideoURI(Uri.parse(url2));//播放网络视频

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (videoView.isPlaying() == false) {
                    videoView.start();
                }
                break;
            case R.id.pause:
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
            case R.id.replay:
                if (videoView.isPlaying()) {
                    videoView.resume();
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initVideoPath();
                }else  {
                    Toast.makeText(this, "请授予权限", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }
}
