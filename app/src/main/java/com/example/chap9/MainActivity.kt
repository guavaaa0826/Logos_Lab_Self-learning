package com.example.chap9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var toastButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.steven)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        setContentView(R.layout.activity_main)

        toastButton = findViewById(R.id.button)

        toastButton.setOnClickListener {
            Toast.makeText(applicationContext, R.string.toast, Toast.LENGTH_LONG).show()
        }
    }
}