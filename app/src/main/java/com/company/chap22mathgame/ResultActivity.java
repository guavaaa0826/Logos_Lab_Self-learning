package com.company.chap22mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView result, comment;
    Button retry, select, exit;

    int score;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.result);
        comment = findViewById(R.id.comment);
        retry = findViewById(R.id.retry);
        select = findViewById(R.id.select);
        exit = findViewById(R.id.exit);

        score = getIntent().getIntExtra("score", 0);
        mode = getIntent().getStringExtra("mode");

        result.setText("Your score is " + score + ".");
        if (score <= 100) {
            comment.setText("You are a FAILURE!");
        } else {
            comment.setText("Get more next time.");
        }

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, GameplayActivity.class);
                intent.putExtra("mode", mode);
                startActivity(intent);
                finish();
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}