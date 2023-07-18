package com.example.chap7viewbindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chap7viewbindingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        var view = mainBinding.root

        setContentView(view)

        mainBinding.button.setOnClickListener {
            mainBinding.textView.text = "Bruh man."
        }
    }
}