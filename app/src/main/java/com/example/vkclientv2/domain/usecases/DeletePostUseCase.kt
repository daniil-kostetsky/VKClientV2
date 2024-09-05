package com.example.vkclientv2.domain.usecases

import com.example.vkclientv2.domain.entity.FeedPost
import com.example.vkclientv2.domain.repository.NewsFeedRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val repository: NewsFeedRepository
) {
   suspend operator fun invoke(feedPost: FeedPost) {
        return repository.deletePost(feedPost)
    }
}