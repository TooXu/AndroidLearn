package com.sf.DarkCalculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    public static SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Log.i(TAG, "onCreate: "+ getLocalClassName() + "  " + getClass().getSimpleName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
