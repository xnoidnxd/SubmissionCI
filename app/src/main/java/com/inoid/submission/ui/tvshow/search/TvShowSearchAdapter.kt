package com.inoid.submission.ui.tvshow.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.inoid.submission.R
import com.inoid.submission.core.BuildConfig
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import com.inoid.submission.ui.body.search.BaseSearchFragmentDirections
import kotlinx.android.synthetic.main.items_movie.view.*

class TvShowSearchAdapter: RecyclerView.Adapter<TvShowSearchAdapter.TvShowViewHolder>() {

    private val listTvShow: ArrayList<TvShowResponse> = ArrayList()

    fun setTvShow(listTvShow: List<TvShowResponse>?) {
        if (listTvShow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(listTvShow)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShowItem = listTvShow[position]
        holder.bind(tvShowItem)
    }

    class TvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShowResponse) {
            with(itemView) {
                tv_item_title.text = tvShow.name
                tv_item_description.text = tvShow.overview
                tv_item_vote_average.text = tvShow.voteAverage.toString()
                tv_item_language.text = tvShow.originalLanguage
                tv_item_popularity.text = String.format("Popularity: ${tvShow.popularity}")

                Glide.with(itemView.context)
                    .load("${BuildConfig.POSTER_PATH}${tvShow.posterPath}")
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)).error(R.drawable.ic_loading)
                    .into(img_poster)

                setOnClickListener {
                    val toDetailTvShowActivity = BaseSearchFragmentDirections.actionBottomSearchToDetailTvShowFragment()
                    toDetailTvShowActivity.tvShowId = tvShow.id
                    it.findNavController().navigate(toDetailTvShowActivity)
                }
            }
        }
    }

}