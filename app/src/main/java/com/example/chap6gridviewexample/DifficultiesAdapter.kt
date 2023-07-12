package com.example.chap6gridviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class DifficultiesAdapter(
    var context: Context,
    var difficultyList: ArrayList<String>,
    var imageList: ArrayList<Int>
) : BaseAdapter() {

    override fun getCount(): Int {
        return difficultyList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // parent!! indicates that the value of parent will not be null.
        val view: View = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.custom_layout, parent, false)
        var difficulty: TextView = view.findViewById(R.id.textView)
        var image: ImageView = view.findViewById(R.id.imageView)

        difficulty.text = difficultyList[position]
        image.setImageResource(imageList[position])

        return view
    }

}