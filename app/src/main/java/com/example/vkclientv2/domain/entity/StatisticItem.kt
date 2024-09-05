package com.example.vkclientv2.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticItem(
    val type: StatisticType,
    val count: Int
) : Parcelable

enum class StatisticType {
    LIKES,
    COMMENTS,
    SHARES,
    VIEWS
}
