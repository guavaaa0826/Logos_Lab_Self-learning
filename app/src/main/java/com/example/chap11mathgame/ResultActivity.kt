package com.example.chap11mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var result: TextView
    private lateinit var comment: TextView
    private lateinit var retry: Button
    private lateinit var select: Button
    private lateinit var exit: Button

    private var score: Int = 0
    private lateinit var mode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        score = intent.getIntExtra("score", 0)
        mode = intent.getStringExtra("mode").toString()

        result = findViewById(R.id.result)
        comment = findViewById(R.id.comment)
        retry = findViewById(R.id.retry)
        select = findViewById(R.id.select)
        exit = findViewById(R.id.exit)

        result.text = "Your score is $score."
        if (score <= 100) {
            comment.text = "You are sooo stoobid!!"
        } else {
            comment.text = "Get more next time."
        }

        retry.setOnClickListener {
            var intent = Intent(this@ResultActivity, GameplayActivity::class.java)
            intent.putExtra("mode", mode)
            startActivity(intent)
            finish()
        }
        select.setOnClickListener {
            var intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
        }
        exit.setOnClickListener {
            // Close the whole activity
            var intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}