package com.example.proyek_uas_meisya_reptiana.di

import com.example.proyek_uas_meisya_reptiana.core.domain.usecase.movie.MovieInteractor
import com.example.proyek_uas_meisya_reptiana.core.domain.usecase.movie.MovieUseCase
import com.example.proyek_uas_meisya_reptiana.ui.movie.MovieViewModel
import com.example.proyek_uas_meisya_reptiana.ui.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
}