package com.example.qoute.apiinterface

import com.example.qoute.model.newsModel.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


const val api_key="9380602832264e52b78ec016a5b03e2e"

interface NewsCall {

    @GET("/v2/everything?q=tesla&from=2023-05-01&sortBy=publishedAt&apiKey=$api_key")
   suspend fun getNews( @Query("q") query: String, @Query("from") fromDate: String,@Query("sortBy") sortBy: String) : Response<NewsModel>

}



