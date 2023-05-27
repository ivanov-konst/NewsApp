package com.example.newsapp.feature.bookmarks.di.domain

import com.example.newsapp.Base.Either
import com.example.newsapp.Base.attempt
import com.example.newsapp.feature.bookmarks.data.local.BookmarksRepository
import com.example.newsapp.feature.domain.ArticleModel

class BookmarksInteractor (private val bookmarksRepository: BookmarksRepository) {
    suspend fun create(model: ArticleModel) {
        attempt { bookmarksRepository.create(model) }
    }

    suspend fun read(): Either<Throwable, List<ArticleModel>> {
        return attempt { bookmarksRepository.read() }
    }

    suspend fun update(model: ArticleModel) {
        attempt { bookmarksRepository.update(model) }
    }

    suspend fun delete(model: ArticleModel) {
        attempt { bookmarksRepository.delete(model) }
    }
}