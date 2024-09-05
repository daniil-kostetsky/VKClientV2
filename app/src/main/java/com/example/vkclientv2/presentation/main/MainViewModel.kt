package com.example.vkclientv2.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkclientv2.data.repository.NewsFeedRepositoryImpl
import com.example.vkclientv2.domain.entity.AuthState
import com.example.vkclientv2.domain.usecases.CheckAuthStateUseCase
import com.example.vkclientv2.domain.usecases.GetAuthStateFlowUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NewsFeedRepositoryImpl(application)

    private val getAuthStateFlowUseCase = GetAuthStateFlowUseCase(repository)
    private val checkAuthStateUseCase = CheckAuthStateUseCase(repository)

    val authState: StateFlow<AuthState> = getAuthStateFlowUseCase()

    fun performAuthResult() {
        viewModelScope.launch {
            checkAuthStateUseCase()
        }
    }
}