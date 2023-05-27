package com.example.newsapp.feature.mainscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsapp.Base.BaseViewModel
import com.example.newsapp.Base.Event
import com.example.newsapp.feature.bookmarks.di.domain.BookmarksInteractor
import com.example.newsapp.feature.domain.ArticlesInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val interactor: ArticlesInteractor,
    private val bookmarksInteractor: BookmarksInteractor
    ) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadArticles)
    }

    override fun initialViewState() = ViewState(
        articlesList = emptyList(),
        articlesShown = emptyList(),
        isSearchEnabled = false
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when(event) {
            is DataEvent.LoadArticles -> {
                viewModelScope.launch {
                    interactor.getArticles().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadArticlesSucceed(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnLoadArticlesSucceed -> {
                return previousState.copy(articlesList = event.articles, articlesShown = event.articles)
            }
            is UiEvent.OnArticleClicked -> {
                viewModelScope.launch {
                    bookmarksInteractor.create(previousState.articlesShown[event.Index])
                }
                return null
            }

            is UiEvent.OnSearchButtonClicked -> {
                return previousState.copy(
                    articlesShown = if (!previousState.isSearchEnabled) previousState.articlesList else previousState.articlesShown,
                    isSearchEnabled = !previousState.isSearchEnabled
                )
            }
            is UiEvent.OnSearchEdit -> {
                return previousState.copy(articlesShown = previousState.articlesList.filter {
                    it.title.contains(
                         event.text
                    )
                })
            }
            else -> return null
        }
    }
}

