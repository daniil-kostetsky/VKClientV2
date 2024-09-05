package com.example.vkclientv2.di

import android.content.Context
import com.example.vkclientv2.data.network.ApiFactory
import com.example.vkclientv2.data.network.ApiService
import com.example.vkclientv2.data.repository.NewsFeedRepositoryImpl
import com.example.vkclientv2.domain.repository.NewsFeedRepository
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindNewsFeedRepository(impl: NewsFeedRepositoryImpl): NewsFeedRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @ApplicationScope
        @Provides
        fun provideVKPreferencesKeyValueStorage(
            context: Context
        ): VKPreferencesKeyValueStorage {
            return VKPreferencesKeyValueStorage(context)
        }
    }
}