package com.example.convert

import com.example.convert.view.java.MyJavaPresenter
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.sample.HelloRepository
import org.koin.sample.HelloRepositoryImpl
import com.example.convert.view.scope.MyScopeActivity
import com.example.convert.view.scope.MyScopePresenter
import com.example.convert.view.simple.MySimplePresenter
import com.example.convert.view.viewmodel.MyViewModel

@JvmField
val appModule = module {
    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }

    // Simple Presenter Factory
    factory { MySimplePresenter(get()) }

    // Simple Java Presenter
    factory { MyJavaPresenter(get()) }

    // scope for MyScopeActivity
    scope(named<MyScopeActivity>()) {
        // scoped MyScopePresenter instance
        scoped { MyScopePresenter(get()) }
    }

    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}