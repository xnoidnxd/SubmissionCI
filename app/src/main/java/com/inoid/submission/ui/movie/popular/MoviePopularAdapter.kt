package com.inoid.submission.ui.movie.popular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.inoid.submission.R
import com.inoid.submission.core.BuildConfig
import com.inoid.submission.core.domain.model.MoviePopular
import com.inoid.submission.ui.body.popular.BasePopularFragmentDirections
import kotlinx.android.synthetic.main.items_movie.view.*

class MoviePopularAdapter: RecyclerView.Adapter<MoviePopularAdapter.MovieViewHolder>() {

    private val listMovie: ArrayList<MoviePopular> = ArrayList()

    fun setMovie(listMovie: List<MoviePopular>?) {
        if (listMovie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(listMovie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieItem = listMovie[position]
        holder.bind(movieItem)
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MoviePopular) {
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
                    val toDetailMovieActivity = BasePopularFragmentDirections.actionBottomPopularToDetailMovieFragment()
                    toDetailMovieActivity.movieId = movie.id
                    it.findNavController().navigate(toDetailMovieActivity)
                }
            }
        }
    }

}