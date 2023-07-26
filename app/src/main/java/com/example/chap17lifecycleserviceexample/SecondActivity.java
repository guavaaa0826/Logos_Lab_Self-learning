package com.example.chap17lifecycleserviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView result;
    ImageView failure;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result = findViewById(R.id.textView);
        failure = findViewById(R.id.imageView);
        back = findViewById(R.id.button);

        Intent intent = getIntent();
        int number = intent.getIntExtra("number", 0);

        if (number >= 100) {
            result.setText("You have " + number + " fans.\nGet more next time.");
        } else if (number > 1) {
            result.setText("You have " + number + " fans.\nGo become a doctor.");
            failure.setVisibility(View.VISIBLE);
        } else if (number > 0) {
            result.setText("You have " + number + " fan.\nGo become a doctor.");
            failure.setVisibility(View.VISIBLE);
        } else if (number == 0) {
            result.setText("You have no fan.\nYou are a FAILURE!");
            failure.setVisibility(View.VISIBLE);
        } else {
            result.setText("You have negative fan!\nYou are such a FAILURE!");
            failure.setVisibility(View.VISIBLE);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("number", number);
                startActivity(intent);
            }
        });

        Log.d("Message", "SecondActivity onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message", "SecondActivity onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message", "SecondActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message", "SecondActivity onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Message", "SecondActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message", "SecondActivity onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Message", "SecondActivity onRestart");
    }
}