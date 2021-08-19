package com.estudos.twitter

import android.app.Application
import com.estudos.twitter.data.di.DataModule
import com.estudos.twitter.domain.di.DomainModule
import com.estudos.twitter.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}