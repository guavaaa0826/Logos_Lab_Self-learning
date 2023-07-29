package com.example.chap20todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText item;
    Button add;
    ListView list;

    ArrayList<String> itemList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = findViewById(R.id.editText);
        add = findViewById(R.id.button);
        list = findViewById(R.id.listView);

        itemList = FileHelper.readData(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemList);
        list.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = item.getText().toString();
                itemList.add(itemName);
                item.setText("");
                FileHelper.writeData(itemList, getApplicationContext());
                adapter.notifyDataSetChanged();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Delete");
                alert.setMessage("Do you want to delete?");
                alert.setCancelable(false);
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                        FileHelper.writeData(itemList, getApplicationContext());
                    }
                });

                AlertDialog alertDialog = alert.create();
                alertDialog.show();
            }
        });
    }
}