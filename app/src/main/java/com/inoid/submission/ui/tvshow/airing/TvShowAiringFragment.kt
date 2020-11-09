package com.inoid.submission.ui.tvshow.airing

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
import kotlinx.android.synthetic.main.fragment_tv_show_airing.*
import javax.inject.Inject

class TvShowAiringFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: TvShowAiringViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show_airing, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val tvShowAdapter = TvShowAiringAdapter()

            viewModel.tvShow.observe(viewLifecycleOwner, Observer { tvShow ->
                if (tvShow != null) {
                    when (tvShow) {
                        is Resource.Loading -> shimmerListLoading(shimmer_tv_show_airing, rv_tvShow_airing)
                        is Resource.Success -> {
                            shimmerListSuccess(shimmer_tv_show_airing, rv_tvShow_airing)

                            Log.d("cektreeed", "onActivityCreated: 2 tvShow = ${Thread.currentThread().name}")
                            tvShowAdapter.setTvShow(tvShow.data)


                        }
                        is Resource.Error ->  shimmerListError(shimmer_tv_show_airing, rv_tvShow_airing, requireContext())
                    }
                }
            })
            Log.d("cektreeed", "onActivityCreated: 3 tvShow =  ${Thread.currentThread().name}")
            with(rv_tvShow_airing) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }


    }

}