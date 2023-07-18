package com.example.chap7lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var result: TextView
    private lateinit var failure: ImageView
    private lateinit var back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        result = findViewById(R.id.textView)
        failure = findViewById(R.id.imageView)
        back = findViewById(R.id.button)

        val number: Int = intent.getStringExtra("number").toString().toInt()

        if (number >= 100) {
            result.text = "You have $number fans.\nGet more next time."
        } else if (number > 1) {
            result.text = "You have $number fans.\nGo become a doctor."
            failure.visibility = View.VISIBLE
        } else if (number > 0) {
            result.text = "You have $number fan.\nGo become a doctor."
            failure.visibility = View.VISIBLE
        } else if (number == 0) {
            result.text = "You have no fan.\nYou are a FAILURE!"
            failure.visibility = View.VISIBLE
        } else {
            result.text = "You have negative fan amount!\nYou are such a FAILURE!"
            failure.visibility = View.VISIBLE
        }

        back.setOnClickListener {
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(intent)
        }

        Log.d("Message", "SecondActivity onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Message", "SecondActivity onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Message", "SecondActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Message", "SecondActivity onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Message", "SecondActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Message", "SecondActivity onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Message", "SecondActivity onRestart")
    }
}