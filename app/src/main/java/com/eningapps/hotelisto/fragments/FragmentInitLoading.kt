package com.eningapps.hotelisto.fragments

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.eningapps.hotelisto.App
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.viewmodel.InitLoadingViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_init_loading.*
import javax.inject.Inject


class FragmentInitLoading : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: InitLoadingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[InitLoadingViewModel::class.java]
        return inflater.inflate(R.layout.fragment_init_loading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observeLoadingState
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(setLoadingState)
    }

    override fun onStart() {
        super.onStart()
        viewModel.onViewStart()
    }


    private val setLoadingState: (InitLoadingViewModel.LoadingState) -> Unit = {
        when (it) {
            InitLoadingViewModel.LoadingState.INIT -> {

            }
            InitLoadingViewModel.LoadingState.LOADING -> {
                loadingStatusTextView.text = "Поиск доступных устройств"
            }
            InitLoadingViewModel.LoadingState.COMPLETE -> {
                loadingStatusTextView.visibility = GONE
                loadingProgressBar.visibility = GONE
                completeLottieView.visibility = VISIBLE
                completeLottieView.playAnimation()
            }
        }
    }
}
