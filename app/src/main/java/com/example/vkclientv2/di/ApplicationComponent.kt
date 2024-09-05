package com.example.vkclientv2.di

import android.content.Context
import com.example.vkclientv2.domain.entity.FeedPost
import com.example.vkclientv2.presentation.ViewModelFactory
import com.example.vkclientv2.presentation.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory

    fun getCommentsScreenComponentFactory(): CommentsScreenComponent.Factory

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}