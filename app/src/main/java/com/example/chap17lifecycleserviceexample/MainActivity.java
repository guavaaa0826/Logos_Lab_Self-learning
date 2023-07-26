package com.example.chap17lifecycleserviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    TextView number;
    Button plusButton, minusButton, sendButton;
    Button classicService, jobIntentService, stopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.textView);
        plusButton = findViewById(R.id.plus);
        minusButton = findViewById(R.id.minus);
        sendButton = findViewById(R.id.send);
        classicService = findViewById(R.id.classicService);
        jobIntentService = findViewById(R.id.jobIntentService);
        stopService = findViewById(R.id.stopService);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                number.setText("" + counter);
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                number.setText("" + counter);
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("number", counter);
                startActivity(intent);
            }
        });
        classicService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClassicService.class);
                startService(intent);
            }
        });
        jobIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JobIntentService.class);
                startService(intent);
            }
        });
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClassicService.class);
                stopService(intent);
                intent = new Intent(getApplicationContext(), JobIntentService.class);
                stopService(intent);
            }
        });

        Log.d("Message", "MainActivity onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message", "MainActivity onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message", "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message", "MainActivity onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Message", "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message", "MainActivity onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Message", "MainActivity onRestart");
    }
}