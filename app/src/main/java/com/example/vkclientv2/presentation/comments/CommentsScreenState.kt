package com.example.vkclientv2.presentation.comments

import com.example.vkclientv2.domain.entity.FeedPost
import com.example.vkclientv2.domain.entity.PostComment

sealed class CommentsScreenState {
    data object Initial : CommentsScreenState()
    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}