package com.example.qoute.model.newsModel

data class Article(
    val source: Source,
    var description: String,
    var title: String,
    var urlToImage: String
)