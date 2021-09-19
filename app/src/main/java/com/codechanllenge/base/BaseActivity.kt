package com.codechanllenge.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.codechanllenge.auth.viewmodel.AuthViewModel
import com.codechanllenge.base.di.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {
    internal val TAG = "BaseActivity"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}