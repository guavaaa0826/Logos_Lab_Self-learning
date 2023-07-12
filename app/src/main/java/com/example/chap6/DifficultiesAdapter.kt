package com.example.chap6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class DifficultiesAdapter(
    var difficulty: ArrayList<String>,
    var description: ArrayList<String>,
    var image: ArrayList<Int>,
    var context: Context
): RecyclerView.Adapter<DifficultiesAdapter.DifficultyView>() {

    // This is the inner class
    class DifficultyView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var difficulty: TextView = itemView.findViewById(R.id.textView1)
        var description: TextView = itemView.findViewById(R.id.textView2)
        var image: CircleImageView = itemView.findViewById(R.id.imageView1)
        var cardView: CardView = itemView.findViewById(R.id.cardView1)
    }

    // This is a constructor.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DifficultyView {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_design, parent, false)

        return DifficultyView(view)
    }

    // This specifies the amount of the items.
    override fun getItemCount(): Int {
        return difficulty.size
    }

    // This function is about the functions of DifficultyView.
    override fun onBindViewHolder(holder: DifficultyView, position: Int) {
        holder.difficulty.text = difficulty.get(position)
        holder.description.text = description.get(position)
        holder.image.setImageResource(image.get(position))

        holder.cardView.setOnClickListener {
            Toast.makeText(context, "You selected ${difficulty.get(position)} mode", Toast.LENGTH_LONG).show()
        }
    }

}