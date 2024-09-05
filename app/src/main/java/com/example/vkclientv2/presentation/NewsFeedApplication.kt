package com.example.vkclientv2.presentation

import android.app.Application
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.vkclientv2.di.ApplicationComponent
import com.example.vkclientv2.di.DaggerApplicationComponent

class NewsFeedApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
    Log.d("getApplicationComponent", "getApplicationComponent")
    return (LocalContext.current.applicationContext as NewsFeedApplication).component
}