package com.example.vkclientv2.navigation

sealed class Screen(
    val route: String
) {
    data object NewsFeed : Screen(ROUTE_NEWS_FEED)
    data object Favorite : Screen(ROUTE_FAVORITE)
    data object Profile : Screen(ROUTE_PROFILE)
    data object Home : Screen(ROUTE_HOME)
    data object Comments : Screen(ROUTE_COMMENTS)

    private companion object {
        const val ROUTE_HOME = "route_home"
        const val ROUTE_NEWS_FEED = "route_news_feed"
        const val ROUTE_COMMENTS = "route_comments"

        const val ROUTE_FAVORITE = "route_favorite"
        const val ROUTE_PROFILE = "route_profile"
    }
}