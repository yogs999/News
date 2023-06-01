package com.example.qoute.reposertry

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.qoute.apiinterface.NewsCall
import com.example.qoute.model.newsModel.NewsModel
import javax.inject.Inject


class NewsRepo @Inject constructor(private var newsInt: NewsCall) {

    private val newsData=MutableLiveData<NewsModel>()

    val newsLive:LiveData<NewsModel>
        get() =newsData

    suspend fun getNews(q:String,from:String,shortBy:String){

     try {
         val result=newsInt.getNews("tesla","2023-04-30","publishedAt")

         result?.let{
             newsData.postValue(result.body())
             Log.d("news2",result.body()?.totalResults.toString())
         }

     }catch(exception:Exception){
         Log.d("newsss",exception.localizedMessage.toString())
     }
          }
}