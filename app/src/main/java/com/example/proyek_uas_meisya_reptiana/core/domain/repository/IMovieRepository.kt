package com.example.proyek_uas_meisya_reptiana.core.domain.repository

import com.example.proyek_uas_meisya_reptiana.core.data.remote.Resource
import com.example.proyek_uas_meisya_reptiana.core.domain.model.Movie
import com.example.proyek_uas_meisya_reptiana.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getMovies(): Flow<Resource<List<Movie>>>
    fun getTvShow(): Flow<Resource<List<TvShow>>>
}