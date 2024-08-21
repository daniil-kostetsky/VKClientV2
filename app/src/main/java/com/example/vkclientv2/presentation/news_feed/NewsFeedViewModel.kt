package com.example.vkclientv2.presentation.news_feed

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.vkclientv2.data.repository.NewsFeedRepository
import com.example.vkclientv2.domain.FeedPost
import com.example.vkclientv2.domain.StatisticItem
import kotlinx.coroutines.launch

class NewsFeedViewModel(application: Application) : AndroidViewModel(application) {

    private val _screenState = MutableLiveData<NewsFeedScreenState>(NewsFeedScreenState.Initial)
    val screenState: LiveData<NewsFeedScreenState> = _screenState

    private val repository = NewsFeedRepository(application)

    init {
        _screenState.value = NewsFeedScreenState.Loading
        loadRecommendations()
    }

    private fun loadRecommendations() {
        viewModelScope.launch {
            _screenState.value = NewsFeedScreenState.Posts(repository.loadRecommendations())
        }
    }
    fun loadNextRecommendations() {
        _screenState.value = NewsFeedScreenState.Posts(
            posts = repository.feedPosts,
            nextDataIsLoading = true
        )
        loadRecommendations()
    }

    fun changeLikeStatus(feedPost: FeedPost) {
        viewModelScope.launch {
            repository.changeLikeStatus(feedPost)
            _screenState.value = NewsFeedScreenState.Posts(repository.feedPosts)
        }
    }

    fun remove(feedPost: FeedPost) {
        viewModelScope.launch {
            repository.deletePost(feedPost)
            _screenState.value = NewsFeedScreenState.Posts(posts = repository.feedPosts)
        }
    }
}