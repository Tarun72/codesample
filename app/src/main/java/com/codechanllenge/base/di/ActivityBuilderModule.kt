package com.codechanllenge.base.di


import com.codechanllenge.auth.di.AuthAppModule
import com.codechanllenge.auth.di.AuthFragmentBuildersModule
import com.codechanllenge.auth.di.AuthScope
import com.codechanllenge.auth.ui.AuthActivity
import com.codechanllenge.auth.viewmodel.AuthViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [
            // View Model
            AuthAppModule::class,
            AuthFragmentBuildersModule::class,
            AuthViewModelModule::class
        ]
    )
    abstract fun contributeAuthActivity(): AuthActivity
}