package com.example.vkclientv2.data.model

import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("id") val id: String, // id post
    @SerializedName("source_id") val communityId: Long,
    @SerializedName("is_favorite") val isFavorite: Boolean,
    @SerializedName("text") val text: String,
    @SerializedName("date") val date: Long,
    @SerializedName("likes") val likes: LikesDto,
    @SerializedName("reposts") val reposts: RepostsDto,
    @SerializedName("views") val views: ViewsDto,
    @SerializedName("comments") val comments: CommentsDto,
    @SerializedName("attachments") val attachments: List<AttachmentDto>?
)