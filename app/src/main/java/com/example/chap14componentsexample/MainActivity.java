package com.example.chap14componentsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView myText, asianMethod;
    Button myButton;
    EditText myEditText;
    CheckBox notAsian, asian;
    RadioGroup myRadioGroup;
    RadioButton bloodB, bloodA, bloodAplus;
    Spinner mySpinner;
    ToggleButton myToggleButton;
    ImageView myImageView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = findViewById(R.id.text1);
        myButton = findViewById(R.id.button1);
        myEditText = findViewById(R.id.editText1);
        notAsian = findViewById(R.id.checkBox1);
        asian = findViewById(R.id.checkBox2);
        myRadioGroup = findViewById(R.id.radioGroup);
        bloodB = findViewById(R.id.radioButton1);
        bloodA = findViewById(R.id.radioButton2);
        bloodAplus = findViewById(R.id.radioButton3);
        mySpinner = findViewById(R.id.spinner1);
        myToggleButton = findViewById(R.id.toggleButton1);
        asianMethod = findViewById(R.id.textView2);
        myImageView = findViewById(R.id.imageView1);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myText.setBackgroundColor(Color.WHITE);
                myButton.setBackgroundColor(Color.RED);

                String output = myEditText.getText().toString();
                if (asian.isChecked()) {
                    if (bloodB.isChecked()) {
                        output = "B stands for FAILURE!";
                    } else if (bloodA.isChecked()) {
                        output = "A stands for average.";
                    } else if (bloodAplus.isChecked()) {
                        output = "Do better next time.";
                    }
                } else if (notAsian.isChecked()) {
                    if (bloodB.isChecked()) {
                        output = "Your blood type is B.";
                    } else if (bloodA.isChecked()) {
                        output = "Your blood type is A.";
                    } else if (bloodAplus.isChecked()) {
                        output = "No, you're not Asian.";
                    }
                } else {
                    output = "You name is " + output + ".";
                }
                myText.setText(output);
            }
        });

        asian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notAsian.setChecked(false);
            }
        });
        notAsian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asian.setChecked(false);
            }
        });

        adapter = ArrayAdapter.createFromResource(this, R.array.asian, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String question = parent.getItemAtPosition(position).toString();
                String answer = "";
                if (question.equals("How to become mature?")) {
                    answer = "When I was 9, I was 25!";
                    asianMethod.setVisibility(View.VISIBLE);
                } else if (question.equals("How to become successful?")) {
                    answer = "I go to school on 1 foot,\nthe other starts a business!";
                    asianMethod.setVisibility(View.VISIBLE);
                } else if (question.equals("How to go to school?")) {
                    answer = "I go 30 miles a day, uphill, both ways!";
                    asianMethod.setVisibility(View.VISIBLE);
                } else if (question.equals("How to manage failures?")) {
                    answer = "EMOTIONAL DAMAGE!!!";
                    asianMethod.setVisibility(View.VISIBLE);
                } else if (question.equals("Select your problem.")) {
                    asianMethod.setVisibility(View.INVISIBLE);
                }
                asianMethod.setText(answer);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                asianMethod.setText("");
            }
        });

        myToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myImageView.setVisibility(View.VISIBLE);
                } else {
                    myImageView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}