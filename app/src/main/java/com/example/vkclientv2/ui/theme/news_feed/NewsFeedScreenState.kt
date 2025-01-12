package com.example.vkclientv2.ui.theme.news_feed

import com.example.vkclientv2.domain.FeedPost

sealed class NewsFeedScreenState {

    data object Initial : NewsFeedScreenState()
    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()
}