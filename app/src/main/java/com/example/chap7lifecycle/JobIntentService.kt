package com.example.chap7lifecycle

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class JobIntentService: JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        Log.d("Service", "JobIntentService onHandleWork")
        Log.d("Service Thread", Thread.currentThread().name)
    }

    // We use companion object so that the function can be accessed from external
    companion object {
        fun myBackgroundService(context: Context, intent: Intent) {
            enqueueWork(context, JobIntentService::class.java, 1, intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service", "JobIntentService onDestroy")
    }
}