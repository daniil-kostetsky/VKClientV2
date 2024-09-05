package com.example.vkclientv2.di

import com.example.vkclientv2.domain.entity.FeedPost
import com.example.vkclientv2.presentation.ViewModelFactory
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [CommentsViewModelModule::class])
interface CommentsScreenComponent {

    fun getViewModelFactory(): ViewModelFactory

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance feedPost: FeedPost
        ): CommentsScreenComponent
    }
}