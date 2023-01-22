package com.example.proyek_uas_meisya_reptiana.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.proyek_uas_meisya_reptiana.core.domain.model.TvShow
import com.project.proyek_akhir_mobile_programming.core.data.remote.response.TvShowResponse

class DivTvShowCallback(private val oldItem: MutableList<TvShow>, private val newItem: MutableList<TvShow>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItem.size

    override fun getNewListSize(): Int = newItem.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItem[oldItemPosition].id == newItem[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItem[oldItemPosition].id == newItem[newItemPosition].id
}