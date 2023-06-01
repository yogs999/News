package com.example.qoute.module

import javax.inject.Qualifier

class NameQualifer {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Wallpaper

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class News

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class DemoQoute
}