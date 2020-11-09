package com.inoid.submission.favorite.body

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inoid.submission.favorite.R
import com.inoid.submission.ui.utils.isInvisible
import kotlinx.android.synthetic.main.fragment_base_favorite.*


class BaseFavoriteFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionPagerAdapter =
            FavoriteSectionPagerAdapter(requireContext(), childFragmentManager)
        view_pager2.adapter = sectionPagerAdapter
        tabs_layout2.setupWithViewPager(view_pager2)

    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
        // use synthetic will result "unsolved reference" if from other module.
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(com.inoid.submission.R.id.bottom_navigation).isInvisible()

    }


}