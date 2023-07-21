package com.example.chap11mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Locale
import kotlin.random.Random

class GameplayActivity : AppCompatActivity() {
    private lateinit var scoreText: TextView
    private lateinit var lifeText: TextView
    private lateinit var timeText: TextView
    private lateinit var question: TextView
    private lateinit var answer: EditText
    private lateinit var submit: Button
    private lateinit var next: Button
    private lateinit var mode: String

    var correctAnswer: Int = 0
    var scoreInt: Int = 0
    var lifeInt: Int = 3

    private lateinit var timer: CountDownTimer
    private val initialTime: Long = 10000 // 10000ms = 10sec
    var timeLeft: Long = initialTime

    // This variable is changed when the submit/next button is clicked.
    // It can prevent consecutively clicking submit to gain score.
    private var answerable: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        mode = intent.getStringExtra("mode").toString()
        supportActionBar!!.title = mode

        scoreText = findViewById(R.id.score)
        lifeText = findViewById(R.id.life)
        timeText = findViewById(R.id.time)
        question = findViewById(R.id.question)
        answer = findViewById(R.id.answer)
        submit = findViewById(R.id.submit)
        next = findViewById(R.id.next)

        gameMaster()

        submit.setOnClickListener {
            val input = answer.text.toString()
            if (answerable) {
                if (input == "") {
                    Toast.makeText(applicationContext, "What da hail you doing?\nWhere's your answer?", Toast.LENGTH_SHORT).show()
                } else {
                    pauseTimer()
                    answerable = false
                    val userAnswer = input.toInt()
                    if (userAnswer == correctAnswer) {
                        scoreInt += 10
                        scoreText.text = "Score = $scoreInt"
                        question.text = "Good. You are right."
                    } else {
                        lifeInt--
                        lifeText.text = "Life = $lifeInt"
                        question.text = "You are stoobid!"
                    }
                }
            }

        }
        next.setOnClickListener {
            pauseTimer()
            resetTimer()
            if (lifeInt == 0) {
                Toast.makeText(applicationContext, "GAME OVER.", Toast.LENGTH_SHORT).show()
                var intent = Intent(this@GameplayActivity, ResultActivity::class.java)
                intent.putExtra("mode", mode)
                intent.putExtra("score", scoreInt)
                startActivity(intent)
                finish()
            } else {
                answerable = true
                gameMaster()
                answer.setText("")
            }
        }
    }

    fun gameMaster() {
        val number1 = Random.nextInt(1, 100)
        val number2 = Random.nextInt(1, 100)
        if (mode == "addition") {
            question.text = "$number1 + $number2 = ?"
            correctAnswer = number1 + number2
        } else if (mode == "subtraction") {
            question.text = "$number1 - $number2 = ?"
            correctAnswer = number1 - number2
        } else if (mode == "multiplication") {
            question.text = "$number1 * $number2 = ?"
            correctAnswer = number1 * number2
        }
        startTimer()
    }

    fun startTimer() {
        // We need to do such indirect assignment since CountDownTimer is an abstract class.
        timer = object: CountDownTimer(timeLeft, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished
                updateText()
            }

            override fun onFinish() {
                pauseTimer()
                resetTimer()
                updateText()

                lifeInt--
                lifeText.text = "Life: $lifeInt"
                question.text = "You are stoobid!!!"
            }

        }.start()
    }

    fun updateText() {
        val remainingTime: Int = (timeLeft / 1000).toInt()
        timeText.text = String.format(Locale.getDefault(), "%02d", remainingTime) // This gives the leading 0.
    }
    fun pauseTimer() {
        timer.cancel()
    }
    fun resetTimer() {
        timeLeft = initialTime
        updateText()
    }
}