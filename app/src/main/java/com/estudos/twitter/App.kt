package com.estudos.twitter

import android.app.Application
import com.estudos.twitter.di.DataModule
import com.estudos.twitter.di.DomainModule
import com.estudos.twitter.di.PresentationModule
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