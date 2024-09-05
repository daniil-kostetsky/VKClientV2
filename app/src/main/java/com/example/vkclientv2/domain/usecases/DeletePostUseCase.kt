package com.example.vkclientv2.domain.usecases

import com.example.vkclientv2.domain.entity.FeedPost
import com.example.vkclientv2.domain.repository.NewsFeedRepository

class DeletePostUseCase(
    private val repository: NewsFeedRepository
) {
   suspend operator fun invoke(feedPost: FeedPost) {
        return repository.deletePost(feedPost)
    }
}