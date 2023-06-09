package com.example.newsapp.feature.bookmarks.data.local

import androidx.room.*
import com.example.newsapp.feature.bookmarks.data.local.model.BookmarkEntity
import com.example.newsapp.feature.bookmarks.di.BOOKMARKS_TABLE
import com.example.newsapp.feature.domain.ArticleModel

class BookmarksLocalSource(private val bookmarksDao: BookmarksDao) {

    suspend fun create(entity: BookmarkEntity) {
            bookmarksDao.create(entity)
        }
    suspend fun read(): List<BookmarkEntity> {
            return bookmarksDao.read()
        }
    suspend fun update(entity: BookmarkEntity) {
            bookmarksDao.update(entity)
        }
    suspend fun delete(entity: BookmarkEntity) {
            bookmarksDao.delete(entity)
        }
}