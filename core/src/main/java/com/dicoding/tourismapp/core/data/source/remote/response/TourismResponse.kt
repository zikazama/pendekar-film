package com.dicoding.tourismapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TourismResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("original_title")
    val original_title: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("release_date")
    val release_date: String,

    @field:SerializedName("vote_count")
    val vote_count: Int,

    @field:SerializedName("poster_path")
    val poster_path: String
)

