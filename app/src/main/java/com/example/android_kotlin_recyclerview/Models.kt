package com.example.android_kotlin_recyclerview

import kotlinx.serialization.Serializable
@Serializable
data class Base(
    val id: Int?,
    val name: String?,
    val news_name: String?,
    val collection: String?,
    val mission: String?
)