package com.example.proyek_uas_meisya_reptiana.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.engine.Resource
import com.example.proyek_uas_meisya_reptiana.core.domain.model.Movie
import com.example.proyek_uas_meisya_reptiana.core.domain.model.TvShow
import com.example.proyek_uas_meisya_reptiana.databinding.FragmentTvShowBinding
import com.example.proyek_uas_meisya_reptiana.ui.detail.DetailActivity
import com.example.proyek_uas_meisya_reptiana.utils.showToast
import com.project.proyek_akhir_mobile_programming.core.data.remote.response.ListResponse
import com.project.proyek_akhir_mobile_programming.core.data.remote.response.TvShowResponse
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private lateinit var binding: FragmentTvShowBinding

    private lateinit var adapter: TvShowAdapter

    private val viewModel: TvShowViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        if (_binding == null){
            _binding = FragmentTvShowBinding.inflate(inflater, container, false)
            binding = _binding as FragmentTvShowBinding
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TvShowAdapter().apply {
            onClick {
                Intent(activity, DetailActivity::class.java).also { intent ->
                    intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.data[1])
                    intent.putExtra(DetailActivity.EXTRA_DATA, it)
                    startActivity(intent)
                }
            }
        }

        getTvShow()
    }

    private fun getTvShow() {
        showLoading(true)
        viewModel.setTvShow()
        viewModel.getTvShow().observe(viewLifecycleOwner){
            if (it != null){
                adapter.tvshow = it as MutableList<TvShow>
                binding.apply {
                    rvTvshow.setHasFixedSize(true)
                    rvTvshow.adapter = adapter
                    showLoading(false)
                }
            }else{
                showLoading(false)
                activity?.showToast("Data Failed to load or Data is Empty")
            }
        }

    }

    private fun showLoading(state: Boolean){
        binding.apply {
            if (state){
                progressBar.visibility = View.VISIBLE
                rvTvshow.visibility = View.GONE
            }else{
                progressBar.visibility = View.GONE
                rvTvshow.visibility = View.VISIBLE
            }
        }
    }

}