package com.example.vkclientv2.domain.usecases

import com.example.vkclientv2.domain.entity.FeedPost
import com.example.vkclientv2.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow

class GetRecommendationsUseCase(
    private val repository: NewsFeedRepository
) {
    operator fun invoke(): StateFlow<List<FeedPost>> {
        return repository.getRecommendations()
    }
}