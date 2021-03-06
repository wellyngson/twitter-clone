package com.estudos.twitter.di

import com.estudos.twitter.ui.detailsuser.DetailsViewModel
import com.estudos.twitter.ui.mainactivity.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule {

    // Exposes the modules to be loaded in the App
    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule(): Module {
        return module {
            viewModel { MainViewModel(userUseCase = get()) }
            viewModel { DetailsViewModel(userUseCase = get()) }
        }
    }
}