package com.example.vkclientv2.presentation.news_feed

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkclientv2.data.extensions.mergeWith
import com.example.vkclientv2.data.repository.NewsFeedRepositoryImpl
import com.example.vkclientv2.domain.entity.FeedPost
import com.example.vkclientv2.domain.usecases.ChangeLikeStatusUseCase
import com.example.vkclientv2.domain.usecases.DeletePostUseCase
import com.example.vkclientv2.domain.usecases.GetRecommendationsUseCase
import com.example.vkclientv2.domain.usecases.LoadNextDataUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class NewsFeedViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NewsFeedRepositoryImpl(application)

    private val getRecommendationsUseCase = GetRecommendationsUseCase(repository)
    private val loadNextDataUseCase = LoadNextDataUseCase(repository)
    private val changeLikeStatusUseCase = ChangeLikeStatusUseCase(repository)
    private val deletePostUseCase = DeletePostUseCase(repository)

    private val recommendationFlow = getRecommendationsUseCase()

    private val loadNextDataFlow = MutableSharedFlow<NewsFeedScreenState>()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ ->
        Log.d("NewsFeedViewModel", "Caught exception")
    }

    val screenState: Flow<NewsFeedScreenState> = recommendationFlow
        .filter {  it.isNotEmpty()}
        .map { NewsFeedScreenState.Posts(it) as NewsFeedScreenState}
        .onStart { emit(NewsFeedScreenState.Loading) }
        .mergeWith(loadNextDataFlow)


    fun loadNextRecommendations() {
        viewModelScope.launch {
            loadNextDataFlow.emit(
                NewsFeedScreenState.Posts(
                    posts = recommendationFlow.value,
                    nextDataIsLoading = true
                )
            )
            loadNextDataUseCase()
        }
    }

    fun changeLikeStatus(feedPost: FeedPost) {
        viewModelScope.launch(coroutineExceptionHandler) {
            changeLikeStatusUseCase(feedPost)
        }
    }

    fun remove(feedPost: FeedPost) {
        viewModelScope.launch(coroutineExceptionHandler) {
            deletePostUseCase(feedPost)
        }
    }
}