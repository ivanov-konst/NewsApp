package com.example.newsapp.feature.bookmarks.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsapp.Base.BaseViewModel
import com.example.newsapp.Base.Event
import com.example.newsapp.feature.bookmarks.di.domain.BookmarksInteractor
import kotlinx.coroutines.launch

class BookmarksScreenViewModel(private val interactor: BookmarksInteractor) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }

    override fun initialViewState(): ViewState = ViewState(bookmarksArticle = emptyList())

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when(event) {
            is DataEvent.LoadBookmarks -> {
                viewModelScope.launch {
                    interactor.read().fold(
                        onError = {},
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }

                    is DataEvent.OnSuccessBookmarksLoaded -> {
                        Log.d("Room", "articleBookmark = ${event.bookmarksArticle}")
                        return previousState.copy(bookmarksArticle = event.bookmarksArticle)
                    }
                    else -> return null
        }
    }
}