package com.estudos.twitter.data.repository

import android.util.Log
import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.DataUser
import com.estudos.twitter.data.service.UserService

class UserRespositoryImpl(
    private val service: UserService
) : UserRepository {

    override suspend fun getTwitterById(searchTwitter: String): DataTweet {
        var responseListTweets: DataTweet
        var dataUser: DataUser

        return try {
            responseListTweets = service.getTweets(searchTwitter)

            responseListTweets.listTweets.forEach {

                dataUser = service.getUserById(it.idUser.toString())

                Log.e("${dataUser.user.name}", "${dataUser.user.username}")

//                it.dataUser.user.name = dataUser.user.name
//                it.dataUser.user.username = dataUser.user.name
            }

            responseListTweets
        } catch (exception: Exception) {
            throw Exception(exception.message)
        }
    }

    override suspend fun getUserById(authorId: String): DataUser {
        var response: DataUser

        return try {
            response = service.getUserById(authorId)

            response
        } catch (exception: Exception) {
            throw Exception(exception.message)
        }

    }
}