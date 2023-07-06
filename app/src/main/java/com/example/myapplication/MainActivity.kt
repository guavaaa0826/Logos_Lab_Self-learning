package com.example.myapplication

import android.app.Application
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.ToggleButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // lateinit means that the variable will be initialized later.
    private lateinit var background: ConstraintLayout
    private lateinit var myText: TextView
    private lateinit var myButton: Button
    private lateinit var myEditText: EditText
    private lateinit var myImageView: ImageView
    private lateinit var notAsian: CheckBox
    private lateinit var asian: CheckBox
    private lateinit var bloodB: RadioButton
    private lateinit var bloodA: RadioButton
    private lateinit var bloodAplus: RadioButton
    private lateinit var myToggleButton: ToggleButton
    private lateinit var mySpinner: Spinner
    private lateinit var asianMethod: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        background = findViewById(R.id.background)
        myText = findViewById(R.id.text1)
        myButton = findViewById(R.id.button1)
        myEditText = findViewById(R.id.editText1)
        myImageView = findViewById(R.id.imageView1)
        myImageView.visibility = View.INVISIBLE
        notAsian = findViewById(R.id.checkBox1)
        asian = findViewById(R.id.checkBox2)
        bloodB = findViewById(R.id.radioButton1)
        bloodA = findViewById(R.id.radioButton2)
        bloodAplus = findViewById(R.id.radioButton3)
        myToggleButton = findViewById(R.id.toggleButton1)
        myToggleButton.isChecked = false
        mySpinner = findViewById(R.id.spinner1)
        mySpinner.onItemSelectedListener = this
        asianMethod = findViewById(R.id.textView2)
        asianMethod.text = "How to be an Asian?"

        asian.setOnClickListener {
            notAsian.isChecked = false
        }
        notAsian.setOnClickListener {
            asian.isChecked = false
        }
        
        myToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                myImageView.visibility = View.VISIBLE
            } else {
                myImageView.visibility = View.GONE
            }
        }

        myButton.setOnClickListener {
            myText.setBackgroundColor(Color.WHITE)
            myButton.setBackgroundColor(Color.RED)

            lateinit var input: String
            if (asian.isChecked) {
                // var is a variable, val is a constant.
                if (bloodB.isChecked) {
                    input = "B stands for FAILURE!"
                } else if (bloodA.isChecked) {
                    input = "A stands for average."
                } else if (bloodAplus.isChecked) {
                    input = "Do better next time."
                }
            } else if (notAsian.isChecked) {
                if (bloodB.isChecked) {
                    input = "Your blood type is B."
                } else if (bloodA.isChecked) {
                    input = "Your blood type is A."
                } else if (bloodAplus.isChecked) {
                    input = "Come on, you're not Asian."
                }
            } else {
                input = "You name is " + myEditText.text.toString()
            }
            myText.text = input
        }

        val arrayAdapter = ArrayAdapter.createFromResource(
            this@MainActivity,
            R.array.Asian,
            android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        mySpinner.adapter = arrayAdapter
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            val choice = parent.getItemAtPosition(position).toString()
            lateinit var str: String

            if (choice == "Select your problem") {
                str = "How to be an Asian?"
                asianMethod.visibility = View.INVISIBLE
            } else if (choice == "How to become mature?") {
                str = "When I was 9, I was 25!"
                asianMethod.visibility = View.VISIBLE
            } else if (choice == "How to become successful?") {
                str = "I go to school on 1 foot,\nthe other starts a business!"
                asianMethod.visibility = View.VISIBLE
            } else if (choice == "How to go to school?") {
                str = "I go 30 miles a day, uphill, both ways!"
                asianMethod.visibility = View.VISIBLE
            } else if (choice == "How to manage failures?") {
                str = "EMOTIONAL DAMAGE!!!"
                asianMethod.visibility = View.VISIBLE
            } else {
                str = "How to be an Asian?"
            }
            asianMethod.text = str

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}