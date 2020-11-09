package com.inoid.submission.ui.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.inoid.submission.R


const val MAX_LINE = 3

// Expendable Text
fun expandableText(context: Context, body: CardView, tvText: TextView, tvNotify: TextView) {
    if (tvText.maxLines > MAX_LINE) {
        tvText.maxLines = MAX_LINE
    }
    body.setOnClickListener {
        if (tvText.maxLines > MAX_LINE) {
            tvText.maxLines = MAX_LINE
            tvNotify.text = context.resources.getString(R.string.sys_read_more)
        } else if (tvText.maxLines <= MAX_LINE) {
            tvText.maxLines = tvText.lineCount
            tvNotify.text = context.resources.getString(R.string.sys_read_less)
        }
    }
}

// Views
fun View.isVisible() {
    visibility = View.VISIBLE
}

fun View.isInvisible() {
    visibility = View.GONE
}

fun shimmerListLoading(shimmer: ShimmerFrameLayout, recyclerView: RecyclerView) {
    shimmer.startShimmer()
    shimmer.isVisible()
    recyclerView.isInvisible()
}

fun shimmerListSuccess(shimmer: ShimmerFrameLayout, recyclerView: RecyclerView) {
    shimmer.stopShimmer()
    shimmer.isInvisible()
    recyclerView.isVisible()
}

fun shimmerListError(shimmer: ShimmerFrameLayout, recyclerView: RecyclerView, context: Context) {
    shimmer.stopShimmer()
    shimmer.isInvisible()
    recyclerView.isInvisible()
    Toast.makeText(context, "Something error!", Toast.LENGTH_SHORT).show()
}

fun shimmerSearchLoading(shimmer: ShimmerFrameLayout, recyclerView: RecyclerView, imageGreet: ImageView, tvError: TextView, imageError: ImageView) {
    shimmer.startShimmer()
    shimmer.isVisible()
    imageGreet.isInvisible()
    tvError.isInvisible()
    imageError.isInvisible()
    recyclerView.isInvisible()
}

fun shimmerSearchEmpty(shimmer: ShimmerFrameLayout, recyclerView: RecyclerView, imageGreet: ImageView, tvError: TextView, imageError: ImageView) {
    shimmer.stopShimmer()
    shimmer.isInvisible()
    imageGreet.isVisible()
    tvError.isInvisible()
    imageError.isInvisible()
    recyclerView.isInvisible()
}

fun shimmerSearchNotFound(shimmer: ShimmerFrameLayout, recyclerView: RecyclerView, tvError: TextView, imageError: ImageView) {
    shimmer.stopShimmer()
    shimmer.isInvisible()
    tvError.isVisible()
    imageError.isVisible()
    recyclerView.isInvisible()
}

fun shimmerSearchSuccess(shimmer: ShimmerFrameLayout, recyclerView: RecyclerView, tvError: TextView, imageError: ImageView) {
    shimmer.stopShimmer()
    shimmer.isInvisible()
    tvError.isInvisible()
    imageError.isInvisible()
    recyclerView.isVisible()
}
