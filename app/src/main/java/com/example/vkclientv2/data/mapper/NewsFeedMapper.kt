package com.example.vkclientv2.data.mapper

import com.example.vkclientv2.data.model.CommentsResponseDto
import com.example.vkclientv2.data.model.NewsFeedResponseDto
import com.example.vkclientv2.domain.entity.FeedPost
import com.example.vkclientv2.domain.entity.PostComment
import com.example.vkclientv2.domain.entity.StatisticItem
import com.example.vkclientv2.domain.entity.StatisticType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import kotlin.math.absoluteValue

class NewsFeedMapper @Inject constructor() {

    fun mapResponseToPosts(response: NewsFeedResponseDto): List<FeedPost> {
        val groups = response.newsFeedContent.groups

        return mutableListOf<FeedPost>().apply {
            response.newsFeedContent.posts.forEach { post ->
                val group = groups.find { it.id == post.communityId.absoluteValue }
                group?.let {
                    add(
                        FeedPost(
                            id = post.id,
                            communityId = post.communityId,
                            communityName = group.name,
                            publicationDate = mapTimestampToDate(post.date),
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
                            isLiked = post.likes.userLikes > 0
                        )
                    )
                }
            }
        }
    }

    private fun mapTimestampToDate(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        return SimpleDateFormat("d MMMM yyyy в hh:mm", Locale.getDefault()).format(date)
    }

    fun mapResponseToComments(response: CommentsResponseDto): List<PostComment> {
        val result = mutableListOf<PostComment>()
        val comments = response.content.comments
        val profiles = response.content.profiles
        for (comment in comments) {
            if (comment.text.isBlank()) continue
            val author = profiles.firstOrNull { it.id == comment.authorId } ?: continue
            result += PostComment(
                id = comment.id,
                authorName = "${author.firstName} ${author.lastName}",
                authorAvatarUrl = author.avatarUrl,
                commentText = comment.text,
                publicationDate = mapTimestampToDate(comment.date)
            )
        }
        return result
    }
}