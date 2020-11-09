package com.inoid.submission.ui.detail.tvshow

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
import com.inoid.submission.core.domain.model.TvShowDetail
import com.inoid.submission.ui.utils.ViewModelFactory
import com.inoid.submission.ui.utils.expandableText
import com.inoid.submission.ui.utils.isInvisible
import com.inoid.submission.ui.utils.isVisible
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_detail_tv_show.*
import javax.inject.Inject


class DetailTvShowFragment : Fragment() {


    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: DetailTvShowViewModel by viewModels {
        factory
    }

    private val args: DetailTvShowFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).bottom_navigation.isInvisible()
        return inflater.inflate(R.layout.fragment_detail_tv_show, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tvShowId = args.tvShowId
        viewModel.setDetail(tvShowId).observe(viewLifecycleOwner, Observer { tvShow ->
            if (tvShow != null) {
                when(tvShow) {
                    is Resource.Loading -> progress_bar_tv_show.isVisible()
                    is Resource.Success -> {
                        progress_bar_tv_show.isInvisible()
                        populateDetail(tvShow.data)
                    }
                    is Resource.Error -> {
                        progress_bar_tv_show.isInvisible()
                        Toast.makeText(context, resources.getString(R.string.toast_error_message), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun populateDetail (tvShow: TvShowDetail?) {
        if (tvShow != null) {
            tv_detail_tv_show_item_title.text = tvShow.name
            tv_detail_tv_show_description.text = tvShow.overview
            tv_detail_tv_show_language.text = tvShow.originalLanguage
            tv_detail_tv_show_rating.text = tvShow.voteAverage.toString()
            tv_detail_tv_show_first_release.text = String.format(" First Release: ${tvShow.firstAirDate}")
            tv_detail_tv_show_last_release.text = String.format(" Last Update: ${tvShow.lastAirDate}")
            tv_detail_tv_show_popularity.text = String.format(" Popularity: ${tvShow.popularity.toString()}")
            tv_detail_tv_show_vote_count.text = String.format(" ${tvShow.voteAverage.toString()} from ${tvShow.voteCount.toString()} vote counted")
            tv_detail_tv_show_status.text = String.format(" Status: ${tvShow.status}")

            sys_tv_show_expand_notify.text = requireContext().resources.getString(R.string.sys_read_more)
            expandableText(requireContext(), body_detail_tv_show_description, tv_detail_tv_show_description, sys_tv_show_expand_notify)

            Glide.with(requireActivity())
                .load("${BuildConfig.POSTER_PATH}${tvShow.posterPath}")
                .into(detail_tv_show_image_poster)

            var statusFavorite = tvShow.isFavorite!!
            setStatusFavorite(statusFavorite)

            fab_favorite2.setOnClickListener { navigate ->
                statusFavorite = !statusFavorite
                viewModel.setFavoriteTvShow(tvShow, statusFavorite)
                setStatusFavorite(statusFavorite)

                setSnackBar(statusFavorite, navigate)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            fab_favorite2.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_white))
        } else {
            fab_favorite2.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_not_favorite_white))
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).bottom_navigation.isInvisible()
    }

    private fun setSnackBar(status: Boolean, navigate: View) {
        if (status) {
            val snack = Snackbar.make(navigate, resources.getString(R.string.snack_message_fav_added), Snackbar.LENGTH_LONG)
            snack.setAction(resources.getString(R.string.snack_go_to_favorite)) {
                val toFavorite = DetailTvShowFragmentDirections.actionDetailTvShowFragmentToBaseFavoriteFragment()
                navigate.findNavController().navigate(toFavorite)
            }.setActionTextColor(ContextCompat.getColor(requireContext(), R.color.purple))
            snack.show()
        } else {
            val snack = Snackbar.make(navigate, resources.getString(R.string.snack_message_fav_delete), Snackbar.LENGTH_LONG)
            snack.show()
        }
    }

}