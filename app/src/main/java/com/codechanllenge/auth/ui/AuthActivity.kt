package com.codechanllenge.auth.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.codechanllenge.R
import com.codechanllenge.auth.viewmodel.AuthViewModel
import com.codechanllenge.base.BaseActivity
import com.codechanllenge.base.di.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class AuthActivity : BaseActivity() {
    @Inject
    lateinit var viewProvideFactoryModule: ViewModelProviderFactory
    lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authViewModel =  ViewModelProvider(this,viewProvideFactoryModule).get(AuthViewModel::class.java)

    }
}