package com.codechanllenge.auth.viewmodel

import androidx.lifecycle.ViewModel
import com.codechanllenge.base.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(characterViewModel: AuthViewModel): ViewModel

}