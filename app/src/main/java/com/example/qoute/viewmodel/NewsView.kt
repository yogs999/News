package com.example.qoute.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qoute.model.newsModel.NewsModel
import com.example.qoute.reposertry.NewsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsView @Inject constructor(private var newsRepo: NewsRepo):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepo.getNews("tesla","2023-04-30","publishedAt")
        }
    }

    val liveNews:LiveData<NewsModel>
        get() =newsRepo.newsLive

}