package com.example.newsapp.feature.data


import com.example.newsapp.feature.data.model.ArticlesRemoteModel

class ArticlesRemoteSource(private val api: NewsApi) {

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles()
    }
}