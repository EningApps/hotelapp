package com.eningapps.hotelisto.fragments

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import com.eningapps.hotelisto.App
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.adapter.NewsAdapter
import com.eningapps.hotelisto.data.entities.internal.News
import com.eningapps.hotelisto.viewmodel.MainViewModel
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.Direction.HORIZONTAL
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import javax.inject.Inject


class FragmentMain : Fragment(), NewsAdapter.NewsClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel

    private lateinit var feedAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.appComponent.inject(this)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    val swipeLeft = SwipeAnimationSetting.Builder()
        .setDirection(Direction.Left)
        .setDuration(500)
        .setInterpolator(AccelerateInterpolator())
        .build()

    val swipeRight = SwipeAnimationSetting.Builder()
        .setDirection(Direction.Right)
        .setDuration(500)
        .setInterpolator(AccelerateInterpolator())
        .build()

    private var currendPosition = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manager = CardStackLayoutManager(context)
        manager.setDirections(HORIZONTAL)
        cardStackView.layoutManager = manager
        feedAdapter = NewsAdapter(context!!, this)
        cardStackView.adapter = feedAdapter


        mainViewModel.photosUrls.subscribe {
            updateContent(it)
        }


        view.likeBtn.setOnClickListener {
            manager.setSwipeAnimationSetting(swipeRight)
            cardStackView.swipe()
            playAnimation(true)
        }
        view.dislikeBtn.setOnClickListener {
            manager.setSwipeAnimationSetting(swipeLeft)
            cardStackView.swipe()
            playAnimation(false)
        }
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.onViewAttach()
    }

    override fun onNewsClicked(newsUrl: String) {
        mainViewModel.moreCLicked(newsUrl)
    }

    private fun updateContent(news: List<News>) {
        feedAdapter.updateNews(news)
    }

    private fun playAnimation(like: Boolean) {
        if (like) {
            likeAnimView.alpha = 1f
            likeAnimView.animate()
                .alpha(0f).apply {
                    startDelay = 150L
                    duration = 150L
                }
                .start()

        } else {
            dislikeAnimView.alpha = 1f
            dislikeAnimView.animate()
                .alpha(0f).apply {
                    startDelay = 150L
                    duration = 150L
                }
                .start()
        }
    }
}
