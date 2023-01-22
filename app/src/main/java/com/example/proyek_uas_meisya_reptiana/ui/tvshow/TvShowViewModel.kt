package com.example.proyek_uas_meisya_reptiana.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.proyek_uas_meisya_reptiana.core.domain.usecase.movie.MovieUseCase


class TvShowViewModel(private val useCase: MovieUseCase): ViewModel() {
    fun getTvShow() = useCase.getTvShow().asLiveData()
    fun setTvShow() {
        TODO("Not yet implemented")
    }
}