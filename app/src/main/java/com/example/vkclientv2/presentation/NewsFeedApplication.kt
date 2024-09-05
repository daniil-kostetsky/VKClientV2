package com.example.vkclientv2.presentation

import android.app.Application
import com.example.vkclientv2.di.ApplicationComponent
import com.example.vkclientv2.di.DaggerApplicationComponent
import com.example.vkclientv2.domain.entity.FeedPost

class NewsFeedApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory()
            .create(
                this, FeedPost(
                    id = 0L,
                    communityId = 0L,
                    communityName = "",
                    publicationDate = "",
                    communityImageUrl = "",
                    contentText = "",
                    contentImageUrl = "",
                    statistics = emptyList(),
                    isLiked = false
                )
            )
    }
}