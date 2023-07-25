package com.example.chap16listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String difficulty[];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView1);
        difficulty = getResources().getStringArray(R.array.difficulty);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, difficulty);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = parent.getItemAtPosition(position).toString();

                if (str.equals("Easy")) {
                    str = "You select easy mode, too easy lah.";
                } else if (str.equals("Asian")) {
                    str = "You select Asian mode and you can't pass,\n you are a FAILURE!.";
                } else if (str.equals("Chinese")) {
                    str = "Neighbor's kid do better.";
                } else if (str.equals("Emotional Damage")) {
                    str = "I will send you to Jesus.";
                }
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
            }
        });
    }
}