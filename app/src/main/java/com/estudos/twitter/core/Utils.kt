package com.estudos.twitter.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object Utils {

    // Check if the user is connected to the internet
    fun isOnline(context: Context): Boolean {
        return if (context != null) {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var networkInfo: NetworkInfo? = null
            if (connectivityManager != null) {
                networkInfo = connectivityManager.activeNetworkInfo
            }
            networkInfo != null && networkInfo.isConnected
        } else {
            false
        }
    }

//    // For handling API responses
//    fun <T : Any> handleApiError(resp: Response<T>): AppState.Error {
//        val error = ApiErrorUtils.parseError(resp)
//        return AppState.Error(Exception(error.message))
//    }
//
//    fun <T : Any> handleSuccess(response: Response<T>): AppState<T> {
//        response.body()?.let {
//            return AppState.Success(it)
//        } ?: return handleApiError(response)
//    }
}