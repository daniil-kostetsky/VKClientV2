package com.example.vkclientv2.presentation.comments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.vkclientv2.data.repository.NewsFeedRepositoryImpl
import com.example.vkclientv2.domain.entity.FeedPost
import com.example.vkclientv2.domain.usecases.GetCommentsUseCase
import kotlinx.coroutines.flow.map

class CommentsViewModel(
    feedPost: FeedPost,
    application: Application
) : AndroidViewModel(application = application) {

    private val repository = NewsFeedRepositoryImpl(application)

    private val getCommentsUseCase = GetCommentsUseCase(repository)

    val screenState = getCommentsUseCase(feedPost)
        .map {
            CommentsScreenState.Comments(
                feedPost = feedPost,
                comments = it
            )
        }
}