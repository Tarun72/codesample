package com.codechanllenge.auth.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.codechanllenge.HomeActivity
import com.codechanllenge.R
import com.codechanllenge.USERNAME_KEY
import com.codechanllenge.auth.presenter.AuthPresenter
import com.codechanllenge.databinding.FragmentLoginBinding

class LoginFragment : BaseAuthFragment() {
    lateinit var loginBinding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBinding.authViewModel = viewModel
        subscribeObserver()
        loginBinding.loginButton.setOnClickListener {
            val homeIntent = Intent(view.context, HomeActivity::class.java)
            homeIntent.putExtra(USERNAME_KEY, viewModel.login.userName)
            startActivity(homeIntent)
            activity?.finish()
        }
    }

    override fun subscribeObserver() {
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer { response ->
            if (response == AuthPresenter.AuthError.invalidUserName()) {
                Log.d(TAG, "subscribeObserver: $response")
                loginBinding.inputUsername.error = response
            } else if (response == AuthPresenter.AuthError.invalidPassword()) {
                loginBinding.inputPassword.error = response
                Log.d(TAG, "subscribeObserver password : $response")
            }
        })
        viewModel.activeLoginLiveData.observe(viewLifecycleOwner, Observer { active ->
            loginBinding.loginButton.isEnabled = active

        })
    }


}