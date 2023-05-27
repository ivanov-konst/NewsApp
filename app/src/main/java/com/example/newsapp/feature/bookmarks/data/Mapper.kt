package com.example.newsapp.feature.bookmarks.data

import com.example.newsapp.feature.bookmarks.data.local.model.BookmarkEntity
import com.example.newsapp.feature.domain.ArticleModel

fun BookmarkEntity.toDomain() = ArticleModel (
    title = title,
    description = description,
    url = url,
    author = author,
    urlToImage = urlToImage,
    publisherAt = publisherAt
)
fun ArticleModel.toEntity() = BookmarkEntity (
    title = title,
    description = description,
    url = url,
    author = author,
    urlToImage = urlToImage,
    publisherAt = publisherAt
)