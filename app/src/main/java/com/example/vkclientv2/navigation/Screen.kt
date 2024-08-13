package com.example.vkclientv2.navigation

import android.net.Uri
import com.example.vkclientv2.domain.FeedPost
import com.google.gson.Gson
import com.google.gson.GsonBuilder

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
            val feedPostJson = Gson().toJson(feedPost)?.encode() ?: ""
            return "$ROUTE_FOR_ARGS/${feedPostJson}" //route_comments/feedPost
        }
    }

    companion object {
        const val ROUTE_HOME = "route_home"
        const val ROUTE_NEWS_FEED = "route_news_feed"
        const val KEY_FEED_POST = "key_feed_post"

        const val ROUTE_COMMENTS = "route_comments/{$KEY_FEED_POST}"

        const val ROUTE_FAVORITE = "route_favorite"
        const val ROUTE_PROFILE = "route_profile"
    }
}
fun String.encode(): String = Uri.encode(this)


