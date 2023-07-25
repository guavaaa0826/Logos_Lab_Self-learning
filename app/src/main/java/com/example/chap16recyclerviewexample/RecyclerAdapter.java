package com.example.chap16recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DifficultyViewHolder> {

    private ArrayList<String> difficultyList;
    private ArrayList<String> descriptionList;
    private ArrayList<Integer> imageList;
    private Context context;

    public RecyclerAdapter(ArrayList<String> difficultyList, ArrayList<String> descriptionList, ArrayList<Integer> imageList, Context context) {
        this.difficultyList = difficultyList;
        this.descriptionList = descriptionList;
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public DifficultyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);
        return new DifficultyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DifficultyViewHolder holder, int position) {
        holder.difficulty.setText(difficultyList.get(position));
        holder.description.setText(descriptionList.get(position));
        holder.image.setImageResource(imageList.get(position));

        holder.cardView.setOnClickListener(v -> {
            Toast.makeText(context, "You selected " + difficultyList.get(position) + " mode", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public int getItemCount() {
        return difficultyList.size();
    }


    public class DifficultyViewHolder extends RecyclerView.ViewHolder {

        private TextView difficulty, description;
        private ImageView image;
        private CardView cardView;

        public DifficultyViewHolder(@NonNull View itemView) {
            super(itemView);

            difficulty = itemView.findViewById(R.id.textView1);
            description = itemView.findViewById(R.id.textView2);
            image = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
