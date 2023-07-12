package com.example.chap6gridviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var myGridView: GridView
    var difficultyList = ArrayList<String>()
    var imageList = ArrayList<Int>()

    fun fillArray() {
        difficultyList.add("Easy")
        difficultyList.add("Asian")
        difficultyList.add("Chinese")
        difficultyList.add("Emotional Damage")
        imageList.add(R.drawable.easy)
        imageList.add(R.drawable.asian)
        imageList.add(R.drawable.chinese)
        imageList.add(R.drawable.emotional_damage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myGridView = findViewById(R.id.gridView1)
        fillArray()

        var adapter = DifficultiesAdapter(this, difficultyList, imageList)
        myGridView.adapter = adapter

        myGridView.setOnItemClickListener { adapterView, view, position, id ->
            lateinit var str: String
            if (difficultyList[position] == "Easy") {
                str = "You select easy mode, too easy lah."
            } else if (difficultyList[position] == "Asian") {
                str = "You are a FAILURE!"
            } else if (difficultyList[position] == "Chinese") {
                str = "Neighbor's kid do better."
            } else if (difficultyList[position] == "Emotional Damage") {
                str = "I will send you to Jesus."
            }
            Toast.makeText(applicationContext, str, Toast.LENGTH_LONG).show()
        }
    }
}