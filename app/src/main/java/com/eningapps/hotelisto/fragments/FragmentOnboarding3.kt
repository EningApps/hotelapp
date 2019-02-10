package com.eningapps.hotelisto.fragments

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eningapps.hotelisto.App
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.adapter.OnboardingAdapter
import com.eningapps.hotelisto.data.entities.ItemWrapper
import com.eningapps.hotelisto.utils.AutoFitGridLayoutManager
import com.eningapps.hotelisto.utils.SpacesItemDecoration
import com.eningapps.hotelisto.viewmodel.OnboardingViewModel
import kotlinx.android.synthetic.main.fragment_onboarding_list.*
import javax.inject.Inject


class FragmentOnboarding3 : Fragment(), OnboardingAdapter.ItemClickListener {

    private val choosenValues: MutableList<String> = ArrayList()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: OnboardingViewModel

    private val rvItems = arrayListOf(
        ItemWrapper(R.drawable.atom, "Physics"),
        ItemWrapper(R.drawable.flasks, "Chemistry"),
        ItemWrapper(R.drawable.axis, "Math"),
        ItemWrapper(R.drawable.cell, "Biology"),
        ItemWrapper(R.drawable.translate, "Languages"),
        ItemWrapper(R.drawable.business, "Economics"),
        ItemWrapper(R.drawable.filming, "Filming"),
        ItemWrapper(R.drawable.online_course, "Online courses"),
        ItemWrapper(R.drawable.online, "Technologies")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[OnboardingViewModel::class.java]
        return inflater.inflate(R.layout.fragment_onboarding_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adaper = OnboardingAdapter(recyclerView.context, rvItems, this)
        val layoutManager = AutoFitGridLayoutManager(recyclerView.context, 500)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adaper
        recyclerView.addItemDecoration(SpacesItemDecoration(40));
        recyclerView.setHasFixedSize(true)
        continueBtn.setOnClickListener {
            viewModel.addInterests(choosenValues)
            viewModel.continueClicked(OnboardingViewModel.OnboardingStep.STEP3)
        }

    }

    override fun onItemClick(containerView: View, checkView: View, value: String) {
        if (choosenValues.contains(value)) {
            choosenValues.remove(value)
            checkView.isActivated = false
        } else {
            choosenValues.add(value)
            checkView.isActivated = true
        }
    }
}
