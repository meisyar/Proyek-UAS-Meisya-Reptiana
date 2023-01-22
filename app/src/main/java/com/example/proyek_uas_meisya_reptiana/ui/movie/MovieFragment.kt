package com.example.proyek_uas_meisya_reptiana.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.proyek_uas_meisya_reptiana.core.domain.model.Movie
import com.example.proyek_uas_meisya_reptiana.databinding.FragmentMovieBinding
import com.example.proyek_uas_meisya_reptiana.ui.detail.DetailActivity
import com.example.proyek_uas_meisya_reptiana.ui.detail.DetailActivity.Companion.data
import com.example.proyek_uas_meisya_reptiana.utils.showToast

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private lateinit var binding: FragmentMovieBinding

    private lateinit var adapter: MovieAdapter

    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        // Inflate the layout for this fragment
        if (_binding == null){
            _binding = FragmentMovieBinding.inflate(inflater, container, false)
            binding = _binding as FragmentMovieBinding
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // init
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
        adapter = MovieAdapter().apply {
            onClick {data ->
                Intent(activity, DetailActivity::class.java).also { intent ->
                    intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.data[0])
                    intent. putExtra(DetailActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            }
        }

        getMovies()
    }

    private fun getMovies() {

        showLoading(true)
        viewModel.setMovies()
        viewModel.getMovies().observe(viewLifecycleOwner){
            if (it != null){
                adapter.movies = it as MutableList<Movie>
                binding.apply {
                    rvMovie.setHasFixedSize(true)
                    rvMovie.adapter = adapter
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
                rvMovie.visibility = View.GONE
            }else{
                progressBar.visibility = View.GONE
                rvMovie.visibility = View.VISIBLE
            }
        }
    }
}