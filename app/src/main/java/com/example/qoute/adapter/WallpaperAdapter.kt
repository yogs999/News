package com.example.qoute.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qoute.databinding.ItemViewBinding
import com.example.qoute.model.wallpapermodel.Wallpapermodel


class WallpaperAdapter(private val context: Context, private val array: Wallpapermodel) : RecyclerView.Adapter<WallpaperAdapter.ViewHolder>() {


    class ViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val arr=array.hits[position]
        holder.binding.type.text=arr.tags
        Glide.with(context).load(arr.webformatURL).into(holder.binding.wallpaperimage)

    }

    override fun getItemCount(): Int {
        return array.hits.size
            }
}