package com.example.chap18example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName, userMessage;
    Button counter;
    CheckBox remember;

    String name, message;
    int count = 0;
    boolean isChecked;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.editTextText);
        userMessage = findViewById(R.id.editTextTextMultiLine);
        counter = findViewById(R.id.button);
        remember = findViewById(R.id.checkBox);

        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                counter.setText("" + count);
            }
        });

        retrieveData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    public void saveData() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        name = userName.getText().toString();
        message = userMessage.getText().toString();
        isChecked = remember.isChecked();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("message", message);
        editor.putInt("count", count);
        editor.putBoolean("isChecked", isChecked);

        editor.commit();
        Toast.makeText(getApplicationContext(), "Data saved.", Toast.LENGTH_LONG).show();
    }

    public void retrieveData() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);

        name = sharedPreferences.getString("name", null);
        message = sharedPreferences.getString("message", null);
        count = sharedPreferences.getInt("count", 0);
        isChecked = sharedPreferences.getBoolean("isChecked", false);

        userName.setText(name);
        userMessage.setText(message);
        counter.setText("" + count);
        remember.setChecked(isChecked);
    }
}