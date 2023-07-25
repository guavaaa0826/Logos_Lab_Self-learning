package com.example.chap16gridviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    private ArrayList<String> difficulty = new ArrayList<>();
    private ArrayList<Integer> image = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        addArray();
        GridAdapter adapter = new GridAdapter(this, difficulty, image);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = "";
                if (Objects.equals(difficulty.get(position), "Easy")) {
                    str = "You select easy mode, too easy lah.";
                } else if (Objects.equals(difficulty.get(position), "Asian")) {
                    str = "You are a FAILURE!";
                } else if (Objects.equals(difficulty.get(position), "Chinese")) {
                    str = "Neighbor's kid do better.";
                } else if (Objects.equals(difficulty.get(position), "Emotional Damage")) {
                    str = "I will send you to Jesus.";
                }
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addArray() {
        difficulty.add("Easy");
        difficulty.add("Asian");
        difficulty.add("Chinese");
        difficulty.add("Emotional Damage");
        image.add(R.drawable.easy);
        image.add(R.drawable.asian);
        image.add(R.drawable.chinese);
        image.add(R.drawable.emotional_damage);
    }
}