package com.example.proyek_uas_meisya_reptiana.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.proyek_uas_meisya_reptiana.core.domain.model.Movie

import com.project.proyek_akhir_mobile_programming.core.data.remote.response.MovieResponse


class DivMovieCallback(private val oldItem: MutableList<Movie>, private val newItem: MutableList<Movie>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItem.size

    override fun getNewListSize(): Int = newItem.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItem[oldItemPosition].id == newItem[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItem[oldItemPosition].id == newItem[newItemPosition].id
}