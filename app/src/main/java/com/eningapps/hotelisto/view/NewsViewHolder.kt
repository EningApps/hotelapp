package com.eningapps.hotelisto.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.eningapps.hotelisto.R
import kotlinx.android.synthetic.main.news_view.view.*

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val newsImage: ImageView = view.newsImage
    val titleText: TextView = view.titleText
    val newsText: TextView = view.newsText
    val moreBtn: View = view.readMoreBtn

    fun loadPhoto(url: String) {
        Glide.with(newsImage.context)
            .load(url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.tooltip_frame_dark)
                    .priority(Priority.IMMEDIATE)
            )
            .into(newsImage)
    }

}