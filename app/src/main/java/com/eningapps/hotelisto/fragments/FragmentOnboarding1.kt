package com.eningapps.hotelisto.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.adapter.OnboardingAdapter1
import com.eningapps.hotelisto.utils.AutoFitGridLayoutManager
import com.eningapps.hotelisto.utils.SpacesItemDecoration
import kotlinx.android.synthetic.main.fragment_onboarding_1.*


class FragmentOnboarding1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adaper = OnboardingAdapter1(recyclerView.context)

        val layoutManager = AutoFitGridLayoutManager(recyclerView.context, 500)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adaper
        recyclerView.addItemDecoration(SpacesItemDecoration(20));
        recyclerView.setHasFixedSize(true)
    }
}
