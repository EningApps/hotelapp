package com.eningapps.hotelisto.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.adapter.OnboardingAdapter
import com.eningapps.hotelisto.data.entities.ItemWrapper
import com.eningapps.hotelisto.utils.AutoFitGridLayoutManager
import com.eningapps.hotelisto.utils.SpacesItemDecoration
import kotlinx.android.synthetic.main.fragment_onboarding_list.*


class FragmentOnboarding2 : Fragment() {

    private val rvItems = arrayListOf(
        ItemWrapper(R.drawable.music, "Music"),
        ItemWrapper(R.drawable.science, "Science"),
        ItemWrapper(R.drawable.cinema, "Cinema"),
        ItemWrapper(R.drawable.books, "Books"),
        ItemWrapper(R.drawable.education, "Education"),
        ItemWrapper(R.drawable.world, "Traveling"),
        ItemWrapper(R.drawable.games, "Videogames"),
        ItemWrapper(R.drawable.tech, "Technologies")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adaper = OnboardingAdapter(recyclerView.context, rvItems)

        val layoutManager = AutoFitGridLayoutManager(recyclerView.context, 500)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adaper
        recyclerView.addItemDecoration(SpacesItemDecoration(40));
        recyclerView.setHasFixedSize(true)
    }
}
