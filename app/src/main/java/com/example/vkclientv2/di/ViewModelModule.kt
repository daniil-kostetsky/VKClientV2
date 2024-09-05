package com.example.vkclientv2.di

import androidx.lifecycle.ViewModel
import com.example.vkclientv2.presentation.comments.CommentsViewModel
import com.example.vkclientv2.presentation.main.MainViewModel
import com.example.vkclientv2.presentation.news_feed.NewsFeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(NewsFeedViewModel::class)
    @Binds
    fun bindNewsFeedViewModel(impl: NewsFeedViewModel): ViewModel

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel
}