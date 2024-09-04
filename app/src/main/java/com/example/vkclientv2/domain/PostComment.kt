package com.example.vkclientv2.domain

import com.example.vkclientv2.R

data class PostComment(
    val id: Long,
    val authorName: String,
    val authorAvatarUrl: String,
    val commentText: String,
    val publicationDate: String
)