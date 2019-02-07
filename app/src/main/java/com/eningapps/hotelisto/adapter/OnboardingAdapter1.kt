package com.eningapps.hotelisto.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.view.OnboardingListItemViewHolder

class OnboardingAdapter1(
    val context: Context
) : RecyclerView.Adapter<OnboardingListItemViewHolder>() {

    private data class ItemWrapper(val iconId: Int, val title: String)

    private val items = arrayListOf(
        ItemWrapper(R.drawable.music, "Music"),
        ItemWrapper(R.drawable.science, "Science"),
        ItemWrapper(R.drawable.cinema, "Cinema"),
        ItemWrapper(R.drawable.books, "Books"),
        ItemWrapper(R.drawable.education, "Education"),
        ItemWrapper(R.drawable.world, "Traveling"),
        ItemWrapper(R.drawable.games, "Videogames"),
        ItemWrapper(R.drawable.tech, "Technologies"),
        ItemWrapper(R.drawable.sport, "Sport")
    )

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
