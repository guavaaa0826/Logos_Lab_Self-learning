package com.example.chap7lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var number: TextView
    private lateinit var plusButton: Button
    private lateinit var minusButton: Button
    private lateinit var sendButton: Button

    private lateinit var classicService: Button
    private lateinit var jobIntentService: Button
    private lateinit var stopService: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number = findViewById(R.id.textView)
        plusButton = findViewById(R.id.plus)
        minusButton = findViewById(R.id.minus)
        sendButton = findViewById(R.id.send)

        classicService = findViewById(R.id.classicService)
        jobIntentService = findViewById(R.id.jobIntentService)
        stopService = findViewById(R.id.stopService)

        plusButton.setOnClickListener {
            var num: Int = number.text.toString().toInt()
            num++
            number.text = num.toString()
        }
        minusButton.setOnClickListener {
            var num: Int = number.text.toString().toInt()
            num--
            number.text = num.toString()
        }
        sendButton.setOnClickListener {
            val num: String = number.text.toString()

            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            // This code transfer the variables to SecondActivity
            intent.putExtra("number", num)
            startActivity(intent)
        }

        classicService.setOnClickListener {
            var intent = Intent(this@MainActivity, ClassicService::class.java)
            startService(intent)
        }
        jobIntentService.setOnClickListener {
            var intent = Intent(this@MainActivity, JobIntentService::class.java)
            JobIntentService.myBackgroundService(this@MainActivity, intent)
            startService(intent)
        }
        stopService.setOnClickListener {
            var intent = Intent(this@MainActivity, ClassicService::class.java)
            stopService(intent)
        }

        // d stands for "debug", which means we can see the log with tag "D".
        Log.d("Message", "MainActivity onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Message", "MainActivity onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Message", "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Message", "MainActivity onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Message", "MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Message", "MainActivity onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Message", "MainActivity onRestart")
    }}