package com.example.proyek_uas_meisya_reptiana.core.data.remote

import com.example.proyek_uas_meisya_reptiana.core.data.remote.network.ApiResponse
import com.example.proyek_uas_meisya_reptiana.core.data.remote.network.ApiService
import com.project.proyek_akhir_mobile_programming.core.data.remote.response.MovieResponse
import com.project.proyek_akhir_mobile_programming.core.data.remote.response.TvShowResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

class MovieRemoteDataSource(private val apiService: ApiService) {

    suspend fun getTvShow(): Flow<ApiResponse<List<TvShowResponse>>> =
        channelFlow {
            try {
                val response = apiService.getTvShow()
                val data = response.results

                if (data.isNotEmpty()) send(ApiResponse.Success(data))
                else send(ApiResponse.Empty)

            }catch (e: Exception){
                e.printStackTrace()
                send(ApiResponse.Error(e.message.toString()))
            }
        }
    suspend fun getMovies(): Flow<ApiResponse<List<MovieResponse>>> =
        channelFlow {
            try {
                val response = apiService.getMovies()
                val data = response.results

                if (data.isNotEmpty()) send(ApiResponse.Success(data))
                else send(ApiResponse.Empty)

            }catch (e: Exception){
                e.printStackTrace()
                send(ApiResponse.Error(e.message.toString()))
            }
        }
}