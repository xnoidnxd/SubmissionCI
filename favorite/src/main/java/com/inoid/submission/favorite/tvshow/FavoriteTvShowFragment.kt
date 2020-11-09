package com.inoid.submission.favorite.tvshow

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
import com.inoid.submission.favorite.R
import com.inoid.submission.favorite.di.DaggerDynamicFeatureComponent
import com.inoid.submission.favorite.utils.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.*
import javax.inject.Inject

class FavoriteTvShowFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FavoriteTvShowViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val coreComponent = (requireActivity().application as MyApplication).coreComponent
        DaggerDynamicFeatureComponent.factory().create(coreComponent).inject(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {

            val tvShowAdapter = FavoriteTvShowAdapter()

            viewModel.favoriteTvShow.observe(viewLifecycleOwner, Observer { tvShow ->
                if (tvShow != null) {
                    tvShowAdapter.setTvShow(tvShow)
                }
                fav_tv_show_image_no_data.visibility = if (tvShow.isNotEmpty()) View.GONE else View.VISIBLE
                fav_tv_show_text_no_data.visibility = if (tvShow.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(rv_favorite_tv_show) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

}