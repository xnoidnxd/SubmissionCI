package com.inoid.submission.ui.body.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.inoid.submission.R
import com.inoid.submission.ui.utils.isVisible
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_base_search.*

class BaseSearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val searchPagerAdapter = SearchPagerAdapter(context, childFragmentManager)
        view_pager_search.adapter = searchPagerAdapter
        tabs_layout_search.setupWithViewPager(view_pager_search)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).bottom_navigation.isVisible()
    }

}