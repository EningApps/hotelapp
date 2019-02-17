package com.eningapps.hotelisto.fragments

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
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


class FragmentOnboarding2 : Fragment(), OnboardingAdapter.ItemClickListener {

    private val choosenValues: MutableList<String> = ArrayList()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: OnboardingViewModel

    private var shouldAnimate = true

    private val rvItems = arrayListOf(
        ItemWrapper(R.drawable.music, "Music"),
        ItemWrapper(R.drawable.science, "Science"),
        ItemWrapper(R.drawable.cinema, "Cinema"),
        ItemWrapper(R.drawable.books, "Books"),
        ItemWrapper(R.drawable.education, "Education"),
        ItemWrapper(R.drawable.world, "Traveling"),
        ItemWrapper(R.drawable.games, "Videogames"),
        ItemWrapper(R.drawable.tech, "Technologies"),
        ItemWrapper(R.drawable.art, "Art"),
        ItemWrapper(R.drawable.sport, "Sport")
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
        recyclerView.addItemDecoration(SpacesItemDecoration(60));
        recyclerView.setHasFixedSize(true)

        loginBtn.setOnClickListener {
            viewModel.addInterests(choosenValues)
            viewModel.continueClicked(OnboardingViewModel.OnboardingStep.STEP2)
        }
    }

    override fun onItemClick(containerView: View, checkView: View, value: String) {
        if (choosenValues.contains(value)) {
            choosenValues.remove(value)
            checkView.isActivated = false
            if (choosenValues.size < 3 && shouldAnimate) {
                shouldAnimate = false
                changeBtnText(true)
            }
        } else {
            choosenValues.add(value)
            checkView.isActivated = true
            if (choosenValues.size == 3) {
                changeBtnText(false)
                shouldAnimate = true
            }
        }
    }

    private fun changeBtnText(reverse: Boolean) {
        val colorFrom = if (reverse) resources.getColor(R.color.green) else resources.getColor(R.color.white)
        val colorTo = if (reverse) resources.getColor(R.color.white) else resources.getColor(R.color.green)
        val bgColorAnimator = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
        val textColorStart = if (reverse) Color.WHITE else Color.BLACK
        val textColorEnd = if (reverse) Color.BLACK else Color.WHITE
        val textColorAnimator = ObjectAnimator.ofArgb(loginBtn, "textColor", textColorStart, textColorEnd)
        val textEnd = if (reverse) resources.getString(R.string.choose_at_leat_3_items) else "CONTINUE"
        val set = AnimatorSet().apply {
            playTogether(bgColorAnimator, textColorAnimator)
            duration = 250
        }
        bgColorAnimator.addUpdateListener { animator ->
            loginBtn.setBackgroundColor(animator.animatedValue as Int)
        }
        textColorAnimator.addUpdateListener { animator ->
            loginBtn.setTextColor(animator.animatedValue as Int)
            loginBtn.text = textEnd
        }
        set.start()
    }
}
