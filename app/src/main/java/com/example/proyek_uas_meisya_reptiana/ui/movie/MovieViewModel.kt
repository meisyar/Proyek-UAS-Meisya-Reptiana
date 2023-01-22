package com.example.proyek_uas_meisya_reptiana.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.proyek_uas_meisya_reptiana.core.domain.usecase.movie.MovieUseCase


class MovieViewModel(private val useCase: MovieUseCase): ViewModel() {
    fun getMovies() = useCase.getMovies().asLiveData()
    fun setMovies() {
        TODO("Not yet implemented")
    }
}