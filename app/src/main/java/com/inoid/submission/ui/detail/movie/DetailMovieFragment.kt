package com.inoid.submission.ui.detail.movie

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.inoid.submission.MyApplication
import com.inoid.submission.R
import com.inoid.submission.core.BuildConfig
import com.inoid.submission.core.data.Resource
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.ui.utils.ViewModelFactory
import com.inoid.submission.ui.utils.expandableText
import com.inoid.submission.ui.utils.isInvisible
import com.inoid.submission.ui.utils.isVisible
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_detail_movie.*
import javax.inject.Inject

class DetailMovieFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: DetailMovieViewModel by viewModels {
        factory
    }

    private val args: DetailMovieFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).bottom_navigation.isInvisible()
        return inflater.inflate(R.layout.fragment_detail_movie, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val movieId = args.movieId
        viewModel.setDetail(movieId).observe(viewLifecycleOwner, Observer { movie->
            if (movie != null) {
                when (movie) {
                    is Resource.Loading -> progress_bar_movie.isVisible()
                    is Resource.Success -> {
                        progress_bar_movie.isInvisible()
                        movie.data?.let { populateDetailMovie(it) }
                    }
                    is Resource.Error -> {
                        progress_bar_movie.isInvisible()
                        Toast.makeText(context, resources.getString(R.string.toast_error_message), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun populateDetailMovie(movie: MovieDetail?) {
        if (movie != null) {
            tv_detail_movie_item_title.text = movie.title
            tv_detail_movie_description.text = movie.overview
            tv_detail_movie_language.text = movie.originalLanguage
            tv_detail_movie_rating.text = movie.voteAverage.toString()
            tv_detail_movie_date.text = String.format(" Released: ${movie.releaseDate}")
            tv_detail_movie_duration.text = String.format(" Duration: ${movie.runtime.toString()}")
            tv_detail_movie_status.text = String.format(" Status: ${movie.status}")

            tv_detail_vote_count.text = String.format(" ${movie.voteAverage.toString()} from ${movie.voteCount.toString()} vote counted")
            tv_detail_movie_popularity.text = String.format("Popularity: ${movie.popularity.toString()}")

            sys_movie_expand_notify.text = context?.resources?.getString(R.string.sys_read_more)
            expandableText(requireContext(), body_detail_movie_description, tv_detail_movie_description, sys_movie_expand_notify)

            Glide.with(requireActivity())
                .load("${BuildConfig.POSTER_PATH}${movie.posterPath}")
                .into(detail_movie_image_poster)

            var statusFavorite = movie.isFavorite!!
            setStatusFavorite(statusFavorite)
            fab_favorite.setOnClickListener { navigate ->
                statusFavorite = !statusFavorite
                viewModel.setFavoriteMovie(movie, statusFavorite)
                setStatusFavorite(statusFavorite)

                setSnackBar(statusFavorite, navigate)

            }

        }


    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            fab_favorite.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_white))
        } else {
            fab_favorite.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_not_favorite_white))
        }
    }

    // When the orientation change, keep the state of toolbar and bottom nav invisible
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).bottom_navigation.isInvisible()
    }

    private fun setSnackBar(status: Boolean, navigate: View) {
        if (status) {
            val snack = Snackbar.make(navigate, resources.getString(R.string.snack_message_fav_added), Snackbar.LENGTH_LONG)
            snack.setAction(resources.getString(R.string.snack_go_to_favorite)) {
                val toFavorite = DetailMovieFragmentDirections.actionDetailMovieFragmentToBaseFavoriteFragment()
                navigate.findNavController().navigate(toFavorite)
            }.setActionTextColor(ContextCompat.getColor(requireContext(), R.color.purple))
            snack.show()
        } else {
            val snack = Snackbar.make(navigate, resources.getString(R.string.snack_message_fav_delete), Snackbar.LENGTH_LONG)
            snack.show()
        }
    }

}