package com.example.chap15example;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
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
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout background;
    TextView myTextView;
    Button myButton;
    EditText myEditText;
    CheckBox notAsian, asian;
    RadioGroup radioGroup;
    RadioButton bloodB, bloodA, bloodAplus;
    Spinner mySpinner;
    ToggleButton myToggleButton;
    ImageView myImageView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = findViewById(R.id.background);
        myTextView = findViewById(R.id.text1);
        myButton = findViewById(R.id.button1);
        myEditText = findViewById(R.id.editText1);
        notAsian = findViewById(R.id.checkBox1);
        asian = findViewById(R.id.checkBox2);
        radioGroup = findViewById(R.id.radioGroup);
        bloodB = findViewById(R.id.radioButton1);
        bloodA = findViewById(R.id.radioButton2);
        bloodAplus = findViewById(R.id.radioButton3);
        mySpinner = findViewById(R.id.spinner1);
        myToggleButton = findViewById(R.id.toggleButton1);
        myImageView = findViewById(R.id.imageView1);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setBackgroundColor(Color.WHITE);
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
                Snackbar.make(background, output, Snackbar.LENGTH_INDEFINITE)
                        .setAction("Close", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
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
                    Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
                } else if (question.equals("How to become successful?")) {
                    answer = "I go to school on 1 foot,\nthe other starts a business!";
                    Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
                } else if (question.equals("How to go to school?")) {
                    answer = "I go 30 miles a day, uphill, both ways!";
                    Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
                } else if (question.equals("How to manage failures?")) {
                    answer = "EMOTIONAL DAMAGE!!!";
                    Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        myToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (myToggleButton.isChecked()) {
                    myImageView.setVisibility(View.VISIBLE);
                } else {
                    showDialogMessage();
                }
            }
        });
    }

    private void showDialogMessage() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Close Reminder")
                .setMessage("Are you closing the reminder?\nYou are still a failure!")
                .setCancelable(false) // This prevents the dialog from closing if the user touch anywhere else.
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        myToggleButton.setChecked(true);
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myImageView.setVisibility(View.INVISIBLE);
                    }
                }).show();
        alertDialog.create();
    }
}