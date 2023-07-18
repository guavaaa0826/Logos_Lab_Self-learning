package com.example.chap7lifecycle

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ClassicService: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Service", "ClassicService onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("Service", "ClassicService onStartCommand")
        Log.d("Service Thread", Thread.currentThread().name)

        // This function stops the service if the task is done.
        // stopSelf()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("Service", "ClassicService onDestroy")
        super.onDestroy()
    }



}