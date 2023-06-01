package com.example.qoute.apiinterface


import com.example.qoute.model.wallpapermodel.Wallpapermodel
import retrofit2.Response
import retrofit2.http.GET


interface WallpaperApi {

    @GET("/api/?key=29119313-f17dff10aea0ded179b582681")
    suspend fun getWallpaper() : Response<Wallpapermodel>


}