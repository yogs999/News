package com.example.qoute.reposertry

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.qoute.model.wallpapermodel.Wallpapermodel
import com.example.qoute.apiinterface.WallpaperApi
import java.lang.Exception
import javax.inject.Inject


class WallpaperRepo @Inject constructor(private val api: WallpaperApi) {

   private val mutableLiveData=MutableLiveData<Wallpapermodel>()

    val getQoutes:LiveData<Wallpapermodel>
        get() = mutableLiveData

    suspend fun getAnimeQoutes(){

          try {
              val result=api.getWallpaper()
              Log.d("yogi",result.message())

              result?.let{
                  mutableLiveData.postValue(result.body())
              }
          }catch(exception:Exception){
              exception.localizedMessage?.let { Log.d("demo", it.toString()) }
          }
 }

}