package com.estudos.twitter.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.estudos.twitter.core.Utils
import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.DataUser
import com.estudos.twitter.data.service.UserService

class UserRespositoryImpl(
    private val context: Context,
    private val service: UserService
) : UserRepository {

    override suspend fun getTwitterById(searchTwitter: String): DataTweet {
        var responseListTweets: DataTweet
        var dataUser: DataUser

        if (Utils.isOnline(context)) {
            return try {
                responseListTweets = service.getTweets(searchTwitter)

                responseListTweets.listTweets.forEach {
                    dataUser = service.getUserById(it.idUser.toString())

                    // Implementar a adicao no banco de dados

                    Log.e("${dataUser.user.name}", "${dataUser.user.username}")

                    it.name = dataUser.user.name
                    it.username = dataUser.user.username

                    Log.e("${it.name}", "${it.username}")

                }

                responseListTweets
            } catch (exception: Exception) {
                throw Exception(exception.message)
            }
        } else {
         // Will be implemented
            Toast.makeText(context, "Sem internet", Toast.LENGTH_LONG).show()

            // use breakpoint on line 43 to not see the lack of internet condition, because right after the application it will break
            responseListTweets = service.getTweets(searchTwitter)
            return responseListTweets
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