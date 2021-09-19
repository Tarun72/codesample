package com.codechanllenge.auth.ui.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.codechanllenge.auth.viewmodel.AuthViewModel
import com.codechanllenge.base.di.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import java.lang.Exception
import javax.inject.Inject

abstract class BaseAuthFragment : DaggerFragment() {
    val TAG = "BaseAuthFragment"

    @Inject
    lateinit var viewProvideFactoryModule: ViewModelProviderFactory
    lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = activity?.run {
            ViewModelProvider(this, viewProvideFactoryModule).get(AuthViewModel::class.java)
        } ?: throw Exception("Invalid activity")

    }

    abstract fun subscribeObserver();
}