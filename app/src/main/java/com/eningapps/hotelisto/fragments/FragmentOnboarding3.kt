package com.eningapps.hotelisto.fragments

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eningapps.hotelisto.App
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.viewmodel.OnboardingViewModel
import kotlinx.android.synthetic.main.fragment_onboarding_welcome.*
import javax.inject.Inject


class FragmentOnboarding3 : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: OnboardingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[OnboardingViewModel::class.java]
        return inflater.inflate(R.layout.fragment_onboarding_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val content = SpannableString("ПОНЯТНО")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        loginBtn.text = content
        loginBtn.setOnClickListener {
            viewModel.continueClicked(OnboardingViewModel.OnboardingStep.STEP3)
        }
    }
}
