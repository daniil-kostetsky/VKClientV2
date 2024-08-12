package com.example.vkclientv2.navigation

import com.example.vkclientv2.domain.FeedPost

sealed class Screen(
    val route: String
) {
    data object NewsFeed : Screen(ROUTE_NEWS_FEED)
    data object Favorite : Screen(ROUTE_FAVORITE)
    data object Profile : Screen(ROUTE_PROFILE)
    data object Home : Screen(ROUTE_HOME)
    data object Comments : Screen(ROUTE_COMMENTS) {
        private const val ROUTE_FOR_ARGS = "route_comments"

        fun getRouteWithArgs(feedPost: FeedPost): String {
            return "$ROUTE_FOR_ARGS/${feedPost.id}" //route_comments/int
        }
    }

    companion object {
        const val ROUTE_HOME = "route_home"
        const val ROUTE_NEWS_FEED = "route_news_feed"
        const val KEY_FEED_POST_ID = "feed_post_id"

        const val ROUTE_COMMENTS = "route_comments/{$KEY_FEED_POST_ID}"

        const val ROUTE_FAVORITE = "route_favorite"
        const val ROUTE_PROFILE = "route_profile"
    }
}