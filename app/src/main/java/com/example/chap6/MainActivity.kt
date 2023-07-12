package com.example.chap6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView
    var difficulty = ArrayList<String>()
    var description = ArrayList<String>()
    var image = ArrayList<Int>()
    private lateinit var adapter: DifficultiesAdapter

    private fun fillArray() {
        difficulty.add("Easy")
        difficulty.add("Asian")
        difficulty.add("Chinese")
        difficulty.add("Emotional Damage")
        description.add("You select easy mode, too easy lah.")
        description.add("You are a FAILURE!")
        description.add("Neighbor's kid do better.")
        description.add("I will send you to Jesus.")
        image.add(R.drawable.easy)
        image.add(R.drawable.asian)
        image.add(R.drawable.chinese)
        image.add(R.drawable.emotional_damage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillArray()

        myRecyclerView = findViewById(R.id.recyclerView1)
        myRecyclerView.layoutManager = LinearLayoutManager(this) // This makes your layout become LinearLayout.

        adapter = DifficultiesAdapter(difficulty, description, image, this)
        myRecyclerView.adapter = adapter

    }
}