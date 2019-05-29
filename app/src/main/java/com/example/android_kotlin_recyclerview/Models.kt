package com.example.android_kotlin_recyclerview

import kotlinx.serialization.Serializable

@Serializable
data class Base(
    val publisher: String?,
    val f2f_url: String?,
    val title: String?,
    val source_url: String?,
    val recipe_id: String?,
    val image_url: String?,
    val social_rank: Number?,
    val publisher_url: String?
)

