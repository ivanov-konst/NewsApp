package com.example.newsapp.feature.data

import com.example.newsapp.feature.data.model.ArticleRemoteModel
import com.example.newsapp.feature.domain.ArticleModel

fun ArticleRemoteModel.toDomain() = ArticleModel(
    title = title,
    author = author ?: "",
    description = description ?: "",
    url = url,
    urlToImage = urlToImage ?: "",
    publisherAt = publishedAt
)