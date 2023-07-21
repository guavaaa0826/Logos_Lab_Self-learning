package com.example.chap11mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var add: Button
    private lateinit var sub: Button
    private lateinit var mul: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        mul = findViewById(R.id.mul)

        add.setOnClickListener {
            var intent = Intent(this@MainActivity, GameplayActivity::class.java)
            intent.putExtra("mode", "addition")
            startActivity(intent)
        }
        sub.setOnClickListener {
            var intent = Intent(this@MainActivity, GameplayActivity::class.java)
            intent.putExtra("mode", "subtraction")
            startActivity(intent)
        }
        mul.setOnClickListener {
            var intent = Intent(this@MainActivity, GameplayActivity::class.java)
            intent.putExtra("mode", "multiplication")
            startActivity(intent)
        }

    }
}