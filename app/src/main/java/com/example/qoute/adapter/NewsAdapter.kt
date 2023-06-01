package com.example.qoute.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qoute.R
import com.example.qoute.model.newsModel.NewsModel

class NewsAdapter(val context: Context, private val arr: NewsModel) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var descriptor = itemView.findViewById<TextView>(R.id.description)
        var image: ImageView = itemView.findViewById<ImageView>(R.id.image)
     //   var backgrounColor = itemView.findViewById<LinearLayout>(R.id.backgroundColor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ltem_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val demo = arr.articles[position]

        holder.title.text = demo.title
        holder.descriptor.text = demo.description
        Glide.with(context).load(demo.urlToImage).into(holder.image)
        holder.itemView.setOnClickListener {
            Toast.makeText(context, demo.title, Toast.LENGTH_SHORT).show()
        }
        /*

        var color = "#3A3939"
        if(position % 2 == 0) {
            color = "#A19D9D"
        }
        holder.backgrounColor.setBackgroundColor(Color.parseColor(color))
    }

    */
    }
    override fun getItemCount(): Int {
        return arr.articles.size
    }
}