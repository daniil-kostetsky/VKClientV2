package com.example.vkclientv2.presentation.news_feed

import com.example.vkclientv2.domain.FeedPost

sealed class NewsFeedScreenState {

    data object Initial : NewsFeedScreenState()
    data object Loading : NewsFeedScreenState()
    data class Posts(
        val posts: List<FeedPost>,
        val nextDataIsLoading: Boolean = false
    ) : NewsFeedScreenState()
}