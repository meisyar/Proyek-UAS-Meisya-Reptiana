package com.example.proyek_uas_meisya_reptiana.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyek_uas_meisya_reptiana.core.domain.model.Movie
import com.example.proyek_uas_meisya_reptiana.core.domain.model.TvShow
import com.example.proyek_uas_meisya_reptiana.databinding.ActivityDetailBinding
import com.example.proyek_uas_meisya_reptiana.utils.*


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataIntent()
    }

    private fun getDataIntent() {
        val type = intent?.extras?.getString(EXTRA_TYPE)

        if (type == data[0]){
            val data = intent?.extras?.getParcelable<Movie>(EXTRA_DATA)
            getDetailMovie(data as Movie)
        }else{
            val data = intent?.extras?.getParcelable<TvShow>(EXTRA_DATA)
            getDetailTvShow(data as TvShow)
        }
    }

    private fun getDetailTvShow(data: TvShow) {
        binding.apply {
            imgDetailPoster.loadImageTvShow("$BASE_URL_API_IMAGE$POSTER_SIZE_W185${data.imgPreview}")
            imgDetailHightlight.loadImageTvShow("$BASE_URL_API_IMAGE$POSTER_SIZE_W780${data.poster}")
            tvTitle.text = data.name
            tvDesc.text = if (data.desc.isNullOrEmpty()) "No Description" else data.desc
            tvReleaseDate.text = data.releaseDate
        }
    }

    private fun getDetailMovie(data: Movie) {
        binding.apply {
            imgDetailPoster.loadImageMovie("$BASE_URL_API_IMAGE$POSTER_SIZE_W780${data.poster}")
            imgDetailHightlight.loadImageMovie("$BASE_URL_API_IMAGE$POSTER_SIZE_W185${data.imgPreview}")
            tvTitle.text = data.name
            tvDesc.text = data.desc
            tvReleaseDate.text = data.releaseDate
        }
    }

    companion object{
        val data = arrayOf("movie", "tv show")
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "type"
    }
}