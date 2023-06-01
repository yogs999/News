package com.example.qoute.dagger

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class BaseClass :Application() {

    override fun onCreate() {
        super.onCreate()

    }
}