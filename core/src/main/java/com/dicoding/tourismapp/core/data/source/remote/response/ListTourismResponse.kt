package com.dicoding.tourismapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTourismResponse(

    @field:SerializedName("results")
    val results: List<TourismResponse>
)