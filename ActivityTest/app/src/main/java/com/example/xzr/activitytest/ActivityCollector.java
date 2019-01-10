package com.example.xzr.activitytest;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    private static final String TAG = "ActivityCollector";
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    public static void finishAll() {
        Log.i(TAG, "finishAll: " + "来了");
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                Log.i(TAG, "finishAll: "+ "for loop");
                activity.isFinishing();
            }
        }
    }
}
