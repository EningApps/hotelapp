package com.eningapps.hotelisto.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_onboarding_list.view.*

class OnboardingListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val iconImage: ImageView = view.iconImage
    val iconText: TextView = view.iconText

    fun setImage(id: Int) {
        Glide.with(iconImage)
            .load(id)
            .into(iconImage)
    }

    fun setText(text: String) {
        iconText.text = text
    }

}