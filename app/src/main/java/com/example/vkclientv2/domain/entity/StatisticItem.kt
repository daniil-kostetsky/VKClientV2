package com.example.vkclientv2.domain.entity

data class StatisticItem(
    val type: StatisticType,
    val count: Int
)

enum class StatisticType {
    LIKES,
    COMMENTS,
    SHARES,
    VIEWS
}