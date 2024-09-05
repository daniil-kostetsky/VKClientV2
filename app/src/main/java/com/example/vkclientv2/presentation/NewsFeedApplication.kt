package com.example.vkclientv2.presentation

import android.app.Application
import com.example.vkclientv2.di.ApplicationComponent
import com.example.vkclientv2.di.DaggerApplicationComponent

class NewsFeedApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}