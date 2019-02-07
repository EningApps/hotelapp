package com.eningapps.hotelisto.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.data.entities.ItemWrapper
import com.eningapps.hotelisto.view.OnboardingListItemViewHolder

class OnboardingAdapter(
    val context: Context,
    val items: List<ItemWrapper>
) : RecyclerView.Adapter<OnboardingListItemViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingListItemViewHolder {
        return OnboardingListItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_onboarding_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OnboardingListItemViewHolder, position: Int) {
        holder.iconImage.setImageResource(items[position].iconId)
        holder.iconText.text = items[position].title
    }
}