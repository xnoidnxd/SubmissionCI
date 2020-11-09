package com.inoid.submission.ui.movie.airing

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.inoid.submission.MyApplication
import com.inoid.submission.R
import com.inoid.submission.core.data.Resource
import com.inoid.submission.ui.utils.ViewModelFactory
import com.inoid.submission.ui.utils.shimmerListError
import com.inoid.submission.ui.utils.shimmerListLoading
import com.inoid.submission.ui.utils.shimmerListSuccess
import kotlinx.android.synthetic.main.fragment_movie_airing.*
import javax.inject.Inject

class MovieAiringFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: MovieAiringViewModel by viewModels {
        factory
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_airing, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val movieAdapter = MovieAiringAdapter()
            viewModel.movie.observe(viewLifecycleOwner, Observer { movie ->
                if (movie != null) {
                    when (movie) {
                        is Resource.Loading -> shimmerListLoading(shimmer_movie_airing, rv_movie_airing)
                        is Resource.Success -> {
                            shimmerListSuccess(shimmer_movie_airing, rv_movie_airing)
                            movieAdapter.setMovie(movie.data)
                        }
                        is Resource.Error -> shimmerListError(shimmer_movie_airing, rv_movie_airing, requireContext())
                    }
                }
            })

            Log.d("cektreeed", "onActivityCreated: 3 movie =  ${Thread.currentThread().name}")
            with(rv_movie_airing) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }

    }
}