package dev.vespertine.recyclerview.Model

import kotlinx.serialization.Serializable


@Serializable
data class DragQueen(
    val id: Int? = -1,
    val name: String? = "",
    val winner: Boolean? = false,
    val missCongeniality: Boolean? = false,
    val image_url: String? = "",
    val quote: String? = "")