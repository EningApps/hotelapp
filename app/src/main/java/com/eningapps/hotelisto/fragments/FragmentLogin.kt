package com.eningapps.hotelisto.fragments

import android.app.Activity
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.eningapps.hotelisto.App
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.viewmodel.LoginViewModel
import com.eningapps.hotelisto.viewmodel.LoginViewModel.LoginState
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_onboarding_welcome.view.*
import javax.inject.Inject


class FragmentLogin : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[LoginViewModel::class.java]
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val content = SpannableString("LOGIN")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        view.loginBtn.text = content
        view.loginBtn.setOnClickListener {
            processLogin()
        }

        passwordEditText.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    hideKeyboard()
                    return processLogin()
                }
                return false
            }
        })
        titleContainer.setOnClickListener {
            hideKeyboard()
        }
        rootContainer.setOnClickListener {
            hideKeyboard()
        }

        viewModel
            .loginState()
            .subscribe {
                showLoginState(it)
            }
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity?.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun processLogin(): Boolean {
        if (loginEditText.text.isBlank()) {
            val anim = AnimationUtils.loadAnimation(context, R.anim.shake_anim)
            loginEditText.startAnimation(anim)
            return false
        }
        if (passwordEditText.text.isBlank()) {
            val anim = AnimationUtils.loadAnimation(context, R.anim.shake_anim)
            passwordEditText.startAnimation(anim)
            return false
        }
        viewModel.processLogin(loginEditText.text.toString(), passwordEditText.text.toString())
        return true
    }

    private fun showLoginState(state: LoginState) {
        when (state) {
            LoginState.VALID -> {
                progressSpinner.visibility = GONE
                incorrectCredintText.visibility = GONE
            }
            LoginState.PROCESS -> {
                progressSpinner.visibility = VISIBLE
                incorrectCredintText.visibility = GONE
            }
            LoginState.ERROR -> {
                progressSpinner.visibility = GONE
                incorrectCredintText.visibility = VISIBLE
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.onViewAttach()
    }
}
