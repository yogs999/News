package com.example.qoute.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qoute.R
import com.example.qoute.model.qoutesmodel.QouteModelItem


class AdapterQoute(val context: Context, private val Qoute: List<QouteModelItem>) : RecyclerView.Adapter<AdapterQoute.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authtxt = itemView.findViewById<TextView>(R.id.authorText)
        val authQotes = itemView.findViewById<TextView>(R.id.qoutess)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = Qoute[position]
        holder.authtxt.text = result.author
        holder.authQotes.text = result.text
    }

    override fun getItemCount(): Int {
        return Qoute.size
    }
}