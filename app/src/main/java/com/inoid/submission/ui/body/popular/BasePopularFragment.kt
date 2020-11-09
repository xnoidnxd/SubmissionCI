package com.inoid.submission.ui.body.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.inoid.submission.R
import com.inoid.submission.ui.utils.isVisible
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_base_popular.*

class BasePopularFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_popular, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val popularPagerAdapter = PopularPagerAdapter(context, childFragmentManager)
        view_pager_popular.adapter = popularPagerAdapter
        tabs_layout_popular.setupWithViewPager(view_pager_popular)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).bottom_navigation.isVisible()
    }
}