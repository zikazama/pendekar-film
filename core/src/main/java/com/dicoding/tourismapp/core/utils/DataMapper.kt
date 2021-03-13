package com.dicoding.tourismapp.core.utils

import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.source.remote.response.TourismResponse
import com.dicoding.tourismapp.core.domain.model.Tourism

object DataMapper {
    fun mapResponsesToEntities(input: List<TourismResponse>): List<TourismEntity> {
        val tourismList = ArrayList<TourismEntity>()
        input.map {
            val tourism = TourismEntity(
                id = it.id,
                overview = it.overview,
                original_title = it.original_title,
                release_date = it.release_date,
                vote_count = it.vote_count,
                poster_path = it.poster_path,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<TourismEntity>): List<Tourism> =
        input.map {
            Tourism(
                id = it.id,
                overview = it.overview,
                original_title = it.original_title,
                release_date = it.release_date,
                vote_count = it.vote_count,
                poster_path = it.poster_path,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Tourism) = TourismEntity(
        id = input.id,
        overview = input.overview,
        original_title = input.original_title,
        release_date = input.release_date,
        vote_count = input.vote_count,
        poster_path = input.poster_path,
        isFavorite = input.isFavorite
    )
}