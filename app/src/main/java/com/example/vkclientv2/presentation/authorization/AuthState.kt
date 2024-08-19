package com.example.vkclientv2.presentation.authorization

sealed class AuthState {

    data object Authorized : AuthState()

    data object NotAuthorized : AuthState()

    data object Initial : AuthState()
}