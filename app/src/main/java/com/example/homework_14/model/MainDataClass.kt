package com.example.homework_14.model

import com.squareup.moshi.Json

data class MainDataClass(
    val content: List<Content>
) {
    data class Content(
        val category: String,
        val cover: String,
        @Json(name = "created_at")
        val createdAt: Long,
        val descriptionEN: String,
        val descriptionKA: String,
        val descriptionRU: String,
        val id: String,
        val isLast: Boolean,
        @Json(name = "publish_date")
        val publishDate: String,
        val published: Int,
        val titleEN: String,
        val titleKA: String,
        val titleRU: String,
        @Json(name = "updated_at")
        val updatedAt: Long
    )
}