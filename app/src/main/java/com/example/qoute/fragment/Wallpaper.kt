package com.example.qoute.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qoute.viewmodel.WallpaperVIewmodel
import com.example.qoute.adapter.WallpaperAdapter
import com.example.qoute.databinding.FragmentWallpaperBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Wallpaper : Fragment() {

     val viewmodel : WallpaperVIewmodel by viewModels()
     lateinit var binding: FragmentWallpaperBinding
     private lateinit var animadapter: WallpaperAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentWallpaperBinding.inflate(layoutInflater,container,false)

      //  viewmodel= ViewModelProvider(this).get(AnimeViewmodel::class.java)

        viewmodel.getAnime.observe(viewLifecycleOwner, Observer {
            binding.recycler.setHasFixedSize(true);
            animadapter = WallpaperAdapter(requireContext(),it)
            binding.recycler.layoutManager=LinearLayoutManager(context)
            binding.recycler.adapter=animadapter

        })

        return binding.root
    }

}