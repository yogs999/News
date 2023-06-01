package com.example.qoute.module

import com.example.qoute.utils.Constanse.base_Url2
import com.example.qoute.utils.Constanse.base_url
import com.example.qoute.utils.Constanse.base_url1
import com.example.qoute.apiinterface.NewsCall
import com.example.qoute.apiinterface.QoutesApi
import com.example.qoute.apiinterface.WallpaperApi
import com.google.errorprone.annotations.Keep
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Keep
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @NameQualifer.Wallpaper
    fun wallpaperIns(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerepo(@NameQualifer.Wallpaper retrofit: Retrofit): WallpaperApi {
        return retrofit.create(WallpaperApi::class.java)
    }


    @Singleton
    @Provides
    @NameQualifer.News
    fun getNewsApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url1)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getNews(@NameQualifer.News retrofit: Retrofit): NewsCall {
        return retrofit.create(NewsCall::class.java)
    }

    @Singleton
    @Provides
    @NameQualifer.DemoQoute
    fun getQoutes(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_Url2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun qotesInterface(@NameQualifer.DemoQoute retrofit: Retrofit): QoutesApi {
        return retrofit.create(QoutesApi::class.java)

    }

}