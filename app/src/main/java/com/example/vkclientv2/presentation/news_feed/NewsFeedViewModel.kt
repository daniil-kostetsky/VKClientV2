package com.example.vkclientv2.presentation.news_feed

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkclientv2.data.mapper.NewsFeedMapper
import com.example.vkclientv2.data.network.ApiFactory
import com.example.vkclientv2.domain.FeedPost
import com.example.vkclientv2.domain.StatisticItem
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import kotlinx.coroutines.launch

class NewsFeedViewModel(private val application: Application) : AndroidViewModel(application) {

    private val _screenState = MutableLiveData<NewsFeedScreenState>(NewsFeedScreenState.Initial)
    val screenState: LiveData<NewsFeedScreenState> = _screenState

    private val mapper = NewsFeedMapper()

    init {
        viewModelScope.launch {
            loadRecommendations()
        }
    }

    private suspend fun loadRecommendations() {
        val storage = VKPreferencesKeyValueStorage(application)
        val token = VKAccessToken.restore(storage) ?: return
        val response = ApiFactory.apiService.loadRecommendations(token.accessToken)
        val feedPosts = mapper.mapResponseToPosts(response)
        _screenState.value = NewsFeedScreenState.Posts(feedPosts)
    }

    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = NewsFeedScreenState.Posts(posts = newPosts)
    }

    fun remove(feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return
        val oldPosts = currentState.posts.toMutableList()
        oldPosts.remove(feedPost)
        _screenState.value = NewsFeedScreenState.Posts(posts = oldPosts)
    }
}