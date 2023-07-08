package com.example.chap5

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        background = findViewById(R.id.background)
        background.setBackgroundColor(Color.YELLOW)
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
                showAlertDialog()
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
            Snackbar.make(background, input, Snackbar.LENGTH_INDEFINITE).setAction(
                "Close", View.OnClickListener {}).show()
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
        lateinit var str: String
        if (parent != null) {
            val choice = parent.getItemAtPosition(position).toString()

            if (choice == "How to become mature?") {
                str = "When I was 9, I was 25!"
                Toast.makeText(this@MainActivity, str, Toast.LENGTH_LONG).show()
            } else if (choice == "How to become successful?") {
                str = "I go to school on 1 foot,\nthe other starts a business!"
                Toast.makeText(this@MainActivity, str, Toast.LENGTH_LONG).show()
            } else if (choice == "How to go to school?") {
                str = "I go 30 miles a day, uphill, both ways!"
                Toast.makeText(this@MainActivity, str, Toast.LENGTH_LONG).show()
            } else if (choice == "How to manage failures?") {
                str = "EMOTIONAL DAMAGE!!!"
                Toast.makeText(this@MainActivity, str, Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("Close Reminder")
            .setMessage("Are you closing the reminder?\nYou are still a failure!")
            .setIcon(R.drawable.alert_dialog)
            .setCancelable(false) // This prevents the dialog from closing if the user touch anywhere else.
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                myImageView.visibility = View.INVISIBLE
            })
        alertDialog.create().show()
    }
}