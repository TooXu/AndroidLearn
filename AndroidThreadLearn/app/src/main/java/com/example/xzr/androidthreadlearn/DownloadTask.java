package com.example.xzr.androidthreadlearn;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import static android.content.ContentValues.TAG;

/**
 * Created by xzr on 2019/1/10.
 */

public class DownloadTask extends AsyncTask<Void,Integer,Boolean> {
    private float progress;


    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            while(true) {
                int downloadPercent = (int) (Math.random() * 101);
                Log.i(TAG, "doInBackground: " + downloadPercent);
                if (downloadPercent >= 100) {
                    break;
                }
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.i(TAG, "onProgressUpdate: " + values[0] + "%");
    }
}
