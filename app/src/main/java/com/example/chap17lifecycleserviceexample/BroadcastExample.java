package com.example.chap17lifecycleserviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class BroadcastExample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Boolean isAirplaneMode = intent.getBooleanExtra("state", false);

        if (isAirplaneMode) {
            Toast.makeText(context, "The device is in airplane mode.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "The device is not in airplane mode.", Toast.LENGTH_LONG).show();
        }

    }
}
