package com.dicoding.tourismapp.core.data.source.remote.network

import com.dicoding.tourismapp.core.data.source.remote.response.ListTourismResponse
import retrofit2.http.GET

interface ApiService {
    @GET("3/trending/movie/day?api_key=d0dde3c9eb1a9053ebf689d243d59ab7")
    suspend fun getList(): ListTourismResponse
}
