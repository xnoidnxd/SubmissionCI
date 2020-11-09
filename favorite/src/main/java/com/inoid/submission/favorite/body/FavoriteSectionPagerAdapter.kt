package com.inoid.submission.favorite.body

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.inoid.submission.R
import com.inoid.submission.favorite.movie.FavoriteMovieFragment
import com.inoid.submission.favorite.tvshow.FavoriteTvShowFragment

class FavoriteSectionPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_show)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvShowFragment()
            else -> Fragment()
        }


    override fun getCount(): Int = TAB_TITLES.size

    override fun getPageTitle(position: Int): CharSequence? = context.resources.getString(
        TAB_TITLES[position])
}