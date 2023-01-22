package com.example.proyek_uas_meisya_reptiana.core.data.remote.network

import com.example.proyek_uas_meisya_reptiana.utils.API_KEY
import com.project.proyek_akhir_mobile_programming.core.data.remote.response.ListResponse
import com.project.proyek_akhir_mobile_programming.core.data.remote.response.MovieResponse
import com.project.proyek_akhir_mobile_programming.core.data.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("movie/now_playing?api_key=$API_KEY")
    suspend fun getMovies(): ListResponse<MovieResponse>

    @GET("tv/airing_today?api_key=$API_KEY")
    suspend fun getTvShow(): ListResponse<TvShowResponse>

}