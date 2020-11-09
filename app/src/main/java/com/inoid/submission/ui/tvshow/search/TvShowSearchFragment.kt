package com.inoid.submission.ui.tvshow.search

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
import kotlinx.android.synthetic.main.fragment_tv_show_search.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class TvShowSearchFragment : Fragment() {

    private val tvShowAdapter = TvShowSearchAdapter()

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: TvShowSearchViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {

            shimmerSearchEmpty(shimmer_tv_show_search, rv_search_tv_show, search_tv_show_greet, search_tv_show_error_text, search_tv_show_error_image)

            search_view_tv_show.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(input: String?): Boolean {

                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    shimmerSearchLoading(shimmer_tv_show_search, rv_search_tv_show, search_tv_show_greet, search_tv_show_error_text, search_tv_show_error_image)
                    if (newText.isNullOrEmpty()) {
                        shimmerSearchEmpty(shimmer_tv_show_search, rv_search_tv_show, search_tv_show_greet, search_tv_show_error_text, search_tv_show_error_image)
                    } else {
                        setSearch(newText)
                    }
                    return false
                }
            })

            with(rv_search_tv_show) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    private fun setSearch(movieName: String) {
        viewModel.setTvShowName(movieName)
        viewModel.searchTvShow()
        viewModel.result?.observe(viewLifecycleOwner, Observer { tvShow ->
            if (tvShow.isNullOrEmpty()) {
                shimmerSearchNotFound(shimmer_tv_show_search, rv_search_tv_show, search_tv_show_error_text, search_tv_show_error_image)
            } else {
                shimmerSearchSuccess(shimmer_tv_show_search, rv_search_tv_show, search_tv_show_error_text, search_tv_show_error_image)
                tvShowAdapter.setTvShow(tvShow)
            }
        })
    }

}