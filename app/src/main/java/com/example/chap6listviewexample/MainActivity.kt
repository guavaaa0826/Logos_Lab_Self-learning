package com.example.chap6listviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var myListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myListView = findViewById(R.id.listView1)
        var diffList = resources.getStringArray(R.array.difficulty)
        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, diffList)
        myListView.adapter = arrayAdapter

        myListView.setOnItemClickListener { parent, view, position, id ->
            var str: String = parent.getItemAtPosition(position).toString()
            if (str == "Easy") {
                str = "You select easy mode, too easy lah."
            } else if (str == "Asian") {
                str = "You select Asian mode and you can't pass,\n you are a FAILURE!."
            } else if (str == "Chinese") {
                str = "Neighbor's kid do better."
            } else if (str == "Emotional Damage") {
                str = "I will send you to Jesus."
            }
            Toast.makeText(applicationContext, str, Toast.LENGTH_LONG).show()
        }
    }
}