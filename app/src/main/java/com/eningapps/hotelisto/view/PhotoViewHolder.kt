package com.eningapps.hotelisto.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.eningapps.hotelisto.R
import kotlinx.android.synthetic.main.photo_view.view.*

class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val photo: ImageView = view.photoImage

    fun loadPhoto(url: String) {
        Glide.with(photo.context)
            .load(url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.tooltip_frame_dark)
                    .priority(Priority.IMMEDIATE)
            )
            .into(photo)
    }

}