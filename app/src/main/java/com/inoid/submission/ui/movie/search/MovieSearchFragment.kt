package com.inoid.submission.ui.movie.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.inoid.submission.MyApplication
import com.inoid.submission.R
import com.inoid.submission.ui.utils.*
import kotlinx.android.synthetic.main.fragment_movie_search.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MovieSearchFragment : Fragment() {

    var name: String? = null

    private val movieAdapter= MovieSearchAdapter()


    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: MovieSearchViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            shimmerSearchEmpty(shimmer_movie_search, rv_search_movie, search_movie_greet, search_movie_error_text, search_movie_error_image)

            search_view_movie.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(input: String?): Boolean {
                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    shimmerSearchLoading(shimmer_movie_search, rv_search_movie, search_movie_greet, search_movie_error_text, search_movie_error_image)
                    if (newText.isNullOrEmpty()) {
                        shimmerSearchEmpty(shimmer_movie_search, rv_search_movie, search_movie_greet, search_movie_error_text, search_movie_error_image)
                    } else {
                        setSearch(newText)
                    }
                    return true
                }
            })

            with(rv_search_movie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    private fun setSearch(movieName: String) {
        viewModel.setMovieName(movieName)
        viewModel.searchMovie()
        viewModel.result?.observe(viewLifecycleOwner, Observer { movie ->
            if (movie.isNullOrEmpty()) {
                shimmerSearchNotFound(shimmer_movie_search, rv_search_movie, search_movie_error_text, search_movie_error_image)
            } else {
                shimmerSearchSuccess(shimmer_movie_search, rv_search_movie, search_movie_error_text, search_movie_error_image)
                movieAdapter.setMovie(movie)
            }
        })
    }
}