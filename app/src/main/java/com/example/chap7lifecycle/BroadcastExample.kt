package com.example.chap7lifecycle

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastExample: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var isAirplaneMode: Boolean = intent!!.getBooleanExtra("state", false)

        if (isAirplaneMode) {
            Toast.makeText(context, "The device is in airplane mode", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "The device is not in airplane mode", Toast.LENGTH_LONG).show()
        }
    }
}