package com.inoid.submission.ui.body.airing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.inoid.submission.R
import com.inoid.submission.ui.utils.isVisible
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_base_airing.*

class BaseAiringFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_airing, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val airingPagerAdapter = AiringPagerAdapter(context, childFragmentManager)
        view_pager_airing.adapter = airingPagerAdapter
        tabs_layout_airing.setupWithViewPager(view_pager_airing)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).bottom_navigation.isVisible()
    }





}