package com.codechanllenge.base.di

import android.app.Application
import com.codechanllenge.base.CodeChallengeApplication
import com.codechanllenge.base.di.viewmodel.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        /**
         * Contains bindings to ensure the usability of {@code dagger.android} framework classes. This
         * module should be installed in the component that is used to inject the {@link
         * android.app.Application} class.
         */
        AndroidInjectionModule::class,
        ViewModelFactoryModule::class,
        AppModule::class,
        ActivityBuilderModule::class
    ]
)
interface AppComponent : AndroidInjector<CodeChallengeApplication> {
    override fun inject(application: CodeChallengeApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}