package com.example.vkclientv2.navigation

sealed class Screen(
    val route: String
) {
    data object NewsFeed : Screen(HOME)
    data object Favorite : Screen(FAVORITE)
    data object Profile : Screen(PROFILE)

    private companion object {
        const val HOME = "route_news_feed"
        const val FAVORITE = "route_favorite"
        const val PROFILE = "route_profile"
    }
}