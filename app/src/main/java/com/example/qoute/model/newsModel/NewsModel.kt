package com.example.qoute.model.newsModel

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)