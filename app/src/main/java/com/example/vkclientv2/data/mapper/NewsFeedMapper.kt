package com.example.vkclientv2.data.mapper

import com.example.vkclientv2.data.model.NewsFeedResponseDto
import com.example.vkclientv2.domain.FeedPost
import com.example.vkclientv2.domain.StatisticItem
import com.example.vkclientv2.domain.StatisticType
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.absoluteValue

class NewsFeedMapper {

    fun mapResponseToPosts(response: NewsFeedResponseDto): List<FeedPost> {
        val groups = response.newsFeedContent.groups

        return mutableListOf<FeedPost>().apply {
            response.newsFeedContent.posts.forEach { post ->
                val group = groups.find { it.id == post.communityId.absoluteValue }
                group?.let {
                    add(
                        FeedPost(
                            id = post.id,
                            communityName = group.name,
                            publicationDate = mapTimestampToDate(post.date * 1000),
                            communityImageUrl = group.imageUrl,
                            contentText = post.text,
                            contentImageUrl = post.attachments?.firstOrNull()?.photo?.photoUrls?.lastOrNull()?.url,
                            statistics = listOf(
                                StatisticItem(type = StatisticType.LIKES, count = post.likes.count),
                                StatisticItem(type = StatisticType.VIEWS, count = post.views.count),
                                StatisticItem(
                                    type = StatisticType.SHARES,
                                    count = post.reposts.count
                                ),
                                StatisticItem(
                                    type = StatisticType.COMMENTS,
                                    count = post.comments.count
                                )
                            ),
                            isFavorite = post.isFavorite
                        )
                    )
                }
            }
        }
    }

    private fun mapTimestampToDate(timestamp: Long): String {
        val date = Date(timestamp)
        return SimpleDateFormat("d MMMM yyyy в hh:mm", Locale.getDefault()).format(date)
    }
}