package com.example.qoute.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qoute.model.wallpapermodel.Wallpapermodel
import com.example.qoute.reposertry.WallpaperRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WallpaperVIewmodel @Inject constructor(private val repo: WallpaperRepo): ViewModel() {


   init {
      viewModelScope.launch(Dispatchers.IO) {
          repo.getAnimeQoutes()
      }
   }

    val getAnime:LiveData<Wallpapermodel>
        get() =repo.getQoutes
}