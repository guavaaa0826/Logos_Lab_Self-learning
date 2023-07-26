package com.example.chap17lifecycleserviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class JobIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public JobIntentService() {
        super("name");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Service", "JobIntentService onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Service", "JobIntentService onStartCommand");
        Log.d("Service Thread", Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Service", "JobIntentService onDestroy");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("Service", "JobIntentService onHandleIntent");
    }
}
