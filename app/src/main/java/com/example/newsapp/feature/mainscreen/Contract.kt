package com.example.newsapp.feature.mainscreen

import com.example.newsapp.Base.Event
import com.example.newsapp.feature.domain.ArticleModel

data class ViewState(
    val isSearchEnabled: Boolean,
    val articlesShown: List<ArticleModel>,
    val articlesList: List<ArticleModel>
)
sealed class UiEvent : Event {
    data class OnArticleClicked(val Index: Int) : UiEvent()
    object OnSearchButtonClicked: UiEvent()
    data class OnSearchEdit(val text: String) : UiEvent()
}


sealed class DataEvent : Event {
    object LoadArticles : DataEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>) :DataEvent()
}