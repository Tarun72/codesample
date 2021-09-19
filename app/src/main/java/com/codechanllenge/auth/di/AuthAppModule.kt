package com.codechanllenge.auth.di

import com.codechanllenge.auth.presenter.AuthPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthAppModule {

    @AuthScope
    @Provides
    fun provideAuthPresenter():AuthPresenter{
        return AuthPresenter()
    }
}