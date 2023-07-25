package com.example.chap16recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<String> difficultyList = new ArrayList<>();
    private ArrayList<String> descriptionList = new ArrayList<>();
    private ArrayList<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        addArray();

        adapter = new RecyclerAdapter(difficultyList, descriptionList, imageList, MainActivity.this);
        recyclerView.setAdapter(adapter);
    }

    private void addArray() {
        difficultyList.add("Easy");
        difficultyList.add("Asian");
        difficultyList.add("Chinese");
        difficultyList.add("Emotional Damage");
        descriptionList.add("You select easy mode, too easy lah.");
        descriptionList.add("You are a FAILURE!");
        descriptionList.add("Neighbor's kid do better.");
        descriptionList.add("I will send you to Jesus.");
        imageList.add(R.drawable.easy);
        imageList.add(R.drawable.asian);
        imageList.add(R.drawable.chinese);
        imageList.add(R.drawable.emotional_damage);
    }
}