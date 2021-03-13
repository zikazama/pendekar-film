package com.dicoding.tourismapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tourism(
    val id: String,
    val original_title: String,
    val overview: String,
    val release_date: String,
    val vote_count: Int,
    val poster_path: String,
    val isFavorite: Boolean
) : Parcelable