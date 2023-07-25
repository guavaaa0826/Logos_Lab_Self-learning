package com.example.chap16gridviewexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    Context context;
    private ArrayList<String> difficulty;
    private ArrayList<Integer> image;

    public GridAdapter(Context context, ArrayList<String> difficulty, ArrayList<Integer> image) {
        this.context = context;
        this.difficulty = difficulty;
        this.image = image;
    }

    @Override
    public int getCount() {
        return difficulty.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder") View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gridview_layout, parent, false);
        ImageView imageView = view.findViewById(R.id.image);
        TextView textView = view.findViewById(R.id.text);

        textView.setText(difficulty.get(position));
        imageView.setImageResource(image.get(position));

        return view;
    }
}
