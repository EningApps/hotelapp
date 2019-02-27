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
import com.eningapps.hotelisto.view.MyWebViewClient
import com.eningapps.hotelisto.viewmodel.WebViewViewModel
import kotlinx.android.synthetic.main.fragment_webview.*
import javax.inject.Inject


class FragmentNewsWebView : Fragment(), MyWebViewClient.OnPageLoadedListener {

    companion object {
        val URL_EXTRA = "URL_EXTRA"

        @JvmStatic
        fun newInstance(url: String) =
            FragmentNewsWebView().apply {
                arguments = Bundle().apply {
                    putString(URL_EXTRA, url)
                }
            }
    }

    private lateinit var newsUrl: String

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: WebViewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newsUrl = it.getString(URL_EXTRA)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[WebViewViewModel::class.java]
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsWebView.setWebViewClient(MyWebViewClient(this));
        newsWebView.getSettings().setJavaScriptEnabled(true);
        newsWebView.loadUrl(newsUrl);
    }

    override fun onPageLoaded() {
        newsWebView.alpha = 1f
    }

    fun onBackPressed(): Boolean {
        if (newsWebView.canGoBack()) {
            newsWebView.goBack()
            return false
        } else {
            return true
        }
    }
}
