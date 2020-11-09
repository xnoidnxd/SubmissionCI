package com.inoid.submission.favorite.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.inoid.submission.core.BuildConfig
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.favorite.R
import com.inoid.submission.favorite.body.BaseFavoriteFragmentDirections
import kotlinx.android.synthetic.main.items_fav.view.*


class FavoriteMovieAdapter: RecyclerView.Adapter<FavoriteMovieAdapter.MovieViewHolder>() {

    private val listMovie: ArrayList<MovieDetail> = ArrayList()

    fun setMovie(listMovie: List<MovieDetail>?) {
        if (listMovie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(listMovie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items_fav, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieItem = listMovie[position]
        holder.bind(movieItem)
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieDetail) {
            with(itemView) {
                tv_item_title.text = movie.title
                tv_item_description.text = movie.overview
                tv_item_vote_average.text = movie.voteAverage.toString()
                tv_item_language.text = movie.originalLanguage
                tv_item_popularity.text = String.format("Popularity: ${movie.popularity}")

                Glide.with(itemView.context)
                    .load("${BuildConfig.POSTER_PATH}${movie.posterPath}")
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)).error(R.drawable.ic_loading)
                    .into(img_poster)

                setOnClickListener {
                    val toDetailMovieActivity = BaseFavoriteFragmentDirections.actionBaseFavoriteFragmentToDetailMovieFragment()
                    toDetailMovieActivity.movieId = movie.id!!
                    it.findNavController().navigate(toDetailMovieActivity)
                }

            }
        }
    }
}