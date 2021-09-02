package com.estudos.twitter.di

import com.estudos.twitter.core.Constants
import com.estudos.twitter.core.Constants.TOKEN_API
import com.estudos.twitter.data.repository.UserRepository
import com.estudos.twitter.data.repository.UserRespositoryImpl
import com.estudos.twitter.data.service.UserService
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun load() {
        loadKoinModules(networkModules() + repositoryModule())
    }

    // Koin module to provide some items of interest to us
    private fun networkModules(): Module {
        return module {
            single {
                OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
                    val newRequest: Request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer $TOKEN_API")
                        .build()
                    chain.proceed(newRequest)
                }).build()
            }

            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }

            single {
                createService<UserService>(get(), get())
            }
        }
    }

    // Koin module to provide some items of interest to us
    private fun repositoryModule(): Module {
        return module {
            single<UserRepository> { UserRespositoryImpl(context = androidContext(), service = get()) }
        }
    }

    private inline fun <reified T> createService(
        client: OkHttpClient,
        factory: GsonConverterFactory
    ): T {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(factory)
            .build().create(T::class.java)
    }
}