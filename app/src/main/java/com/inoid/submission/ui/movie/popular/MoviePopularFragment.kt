package com.inoid.submission.ui.movie.popular

import android.content.Context
import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_movie_popular.*
import javax.inject.Inject


class MoviePopularFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: MoviePopularViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_popular, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val movieAdapter = MoviePopularAdapter()

            viewModel.movie.observe(viewLifecycleOwner, Observer { movie ->
                if (movie != null) {
                    when (movie) {
                        is Resource.Loading -> shimmerListLoading(shimmer_movie_popular, rv_movie_popular)
                        is Resource.Success -> {
                            shimmerListSuccess(shimmer_movie_popular, rv_movie_popular)
                            movieAdapter.setMovie(movie.data)
                        }
                        is Resource.Error -> shimmerListError(shimmer_movie_popular, rv_movie_popular, requireContext())
                    }
                }
            })

            with(rv_movie_popular) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}