package com.estudos.twitter.di

import com.estudos.twitter.domain.UserUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    // Exposes the modules to be loaded in the App
    fun load() {
        loadKoinModules(useCaseModule())
    }

    // Koin module to provide our Use Cases
    private fun useCaseModule(): Module {
        return module {
            factory {
                UserUseCase(repository = get())
            }
        }
    }
}