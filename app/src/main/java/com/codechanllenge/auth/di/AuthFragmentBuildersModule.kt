package com.codechanllenge.auth.di

import com.codechanllenge.auth.ui.fragment.LauncherFragment
import com.codechanllenge.auth.ui.fragment.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
// it provide objects to object graph
abstract class AuthFragmentBuildersModule {


    //This annotation must be applied to an abstract method in a Module that returns a concrete Android framework type
    // (e.g. FooActivity, BarFragment, MyService, etc).
    // The method should have no parameters.

    @ContributesAndroidInjector()
    abstract fun contributeLauncherFragment(): LauncherFragment

    @ContributesAndroidInjector()
    abstract fun contributeLoginFragment(): LoginFragment


}