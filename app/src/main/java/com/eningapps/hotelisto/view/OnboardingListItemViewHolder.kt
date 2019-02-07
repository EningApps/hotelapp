package com.eningapps.hotelisto.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_onboarding_list.view.*

class OnboardingListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val iconImage: ImageView = view.imageView
    val iconText: TextView = view.textView
}