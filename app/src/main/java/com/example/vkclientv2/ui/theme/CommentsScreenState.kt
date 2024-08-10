package com.example.vkclientv2.ui.theme

import com.example.vkclientv2.domain.FeedPost
import com.example.vkclientv2.domain.PostComment

sealed class CommentsScreenState {
    data object Initial : CommentsScreenState()
    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}