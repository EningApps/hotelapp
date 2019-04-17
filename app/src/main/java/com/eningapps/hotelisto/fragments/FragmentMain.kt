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
import com.eningapps.hotelisto.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.layout_kitchen.*
import kotlinx.android.synthetic.main.layout_security.*
import javax.inject.Inject


class FragmentMain : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.appComponent.inject(this)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTexts()
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.onViewAttach()
    }

    private fun setupTexts() {
        val content = SpannableString("Смотреть")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        watchCamerasBtn.text = content
        watchCamerasBtn.setOnClickListener {
            //mainViewModel.continueClicked(OnboardingViewModel.OnboardingStep.STEP2)
        }
        val content2 = SpannableString("Готов к работе")
        content2.setSpan(UnderlineSpan(), 0, content2.length, 0)
        multyCookReadyBtn.text = content2
        multyCookReadyBtn.setOnClickListener {
            //mainViewModel.continueClicked(OnboardingViewModel.OnboardingStep.STEP2)
        }
    }
}
