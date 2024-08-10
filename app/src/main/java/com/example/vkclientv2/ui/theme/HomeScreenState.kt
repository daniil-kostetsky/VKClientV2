package com.example.vkclientv2.ui.theme

import com.example.vkclientv2.domain.FeedPost
import com.example.vkclientv2.domain.PostComment

sealed class HomeScreenState {

    data object Initial : HomeScreenState()
    data class Posts(val posts: List<FeedPost>) : HomeScreenState()
    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>) : HomeScreenState()
}