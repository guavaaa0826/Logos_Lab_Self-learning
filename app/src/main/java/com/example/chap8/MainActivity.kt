package com.example.chap8

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var userMessage: EditText
    private lateinit var counter: Button
    private lateinit var remember: CheckBox

    var name: String? = null // This container is for the userName
    var message: String? = null // This container is for the userMessage
    var count: Int = 0 // This container is for the counter
    var isChecked: Boolean? = null // This container is for remember

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.editTextText)
        userMessage = findViewById(R.id.editTextTextMultiLine)
        counter = findViewById(R.id.button)
        remember = findViewById(R.id.checkBox)

        counter.setOnClickListener {
            count++
            counter.text = count.toString()
        }
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        retrieveData()
    }

    private fun saveData() {
        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        name = userName.text.toString()
        message = userMessage.text.toString()
        isChecked = remember.isChecked

        val editor = sharedPreferences.edit()

        editor.putString("key name", name)
        editor.putString("key message", message)
        editor.putInt("key count", count)
        editor.putBoolean("key isChecked", isChecked!!)

        editor.apply() // Stores the data in the editor
        Toast.makeText(applicationContext, "Your data is saved.", Toast.LENGTH_LONG).show()
    }

    private fun retrieveData() {
        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)

        name = sharedPreferences.getString("key name", null)
        message = sharedPreferences.getString("key message", null)
        count = sharedPreferences.getInt("key count", 0)
        isChecked = sharedPreferences.getBoolean("key isChecked", false)

        userName.setText(name)
        userMessage.setText(message)
        counter.text = count.toString()
        remember.isChecked = isChecked!!
    }
}