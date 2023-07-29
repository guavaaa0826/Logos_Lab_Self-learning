package com.company.chap22mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class GameplayActivity extends AppCompatActivity {

    TextView scoreText, timeText, lifeText, question;
    EditText answer;
    Button submit, next;

    String mode;
    int scoreInt = 0, lifeInt = 3;
    int number1, number2, solution;
    Random random = new Random();
    boolean submitClickable;

    boolean timer_running;
    CountDownTimer timer;
    private static final long START_TIMER = 10000;
    long time_left = START_TIMER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        scoreText = findViewById(R.id.score);
        timeText = findViewById(R.id.time);
        lifeText = findViewById(R.id.life);
        question = findViewById(R.id.question);
        answer = findViewById(R.id.answer);
        submit = findViewById(R.id.submit);
        next = findViewById(R.id.next);
        mode = getIntent().getStringExtra("mode");
        getSupportActionBar().setTitle(mode);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = answer.getText().toString();
                if (submitClickable) {
                    if (input.equals("")) {
                        Toast.makeText(getApplicationContext(), "What da hail you doing?\nWhere's your answer?", Toast.LENGTH_SHORT).show();
                    } else {
                        submitClickable = false;
                        pauseTimer();
                        int userAnswer = Integer.parseInt(input);
                        if (userAnswer == solution) {
                            scoreInt += 10;
                            scoreText.setText("Score: " + scoreInt);
                            question.setText("Good. You got it right.");
                        } else {
                            lifeInt--;
                            lifeText.setText("Life: " + lifeInt);
                            question.setText("You are stoobid!");
                        }
                    }
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
                resetTimer();
                if (lifeInt == 0) {
                    Toast.makeText(getApplicationContext(), "GAME OVER.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(GameplayActivity.this, ResultActivity.class);
                    intent.putExtra("mode", mode);
                    intent.putExtra("score", scoreInt);
                    startActivity(intent);
                    finish();
                } else {
                    answer.setText("");
                    gameMaster();
                }
            }
        });

        gameMaster();
    }

    public void gameMaster() {
        submitClickable = true;
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);
        if (Objects.equals(mode, "addition")) {
            question.setText(number1 + " + " + number2);
            solution = number1 + number2;
        } else if (Objects.equals(mode, "subtraction")) {
            if (number1 >= number2) {
                question.setText(number1 + " - " + number2);
                solution = number1 - number2;
            } else {
                question.setText(number2 + " - " + number1);
                solution = number2 - number1;
            }
        } else if (Objects.equals(mode, "multiplication")) {
            question.setText(number1 + " * " + number2);
            solution = number1 * number2;
        }

        startTimer();
    }

    public void startTimer() {
        timer = new CountDownTimer(time_left, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_left = millisUntilFinished;
                updateText();
            }

            @Override
            public void onFinish() {
                timer_running = false;
                pauseTimer();
                resetTimer();
                updateText();
                lifeInt--;
                lifeText.setText("Life: " + lifeInt);
                question.setText("You have no time,\n like you have no friend.");
            }
        }.start();
        timer_running = true;
    }

    public void updateText() {
        int timeInt = (int)(time_left / 1000);
        // String timeStr = String.format(Locale.getDefault(), "%02d", timeInt);
        timeText.setText("Time: " + timeInt);
    }

    public void pauseTimer() {
        timer.cancel();
        timer_running = false;
    }

    public void resetTimer() {
        time_left = START_TIMER;
        updateText();
    }
}