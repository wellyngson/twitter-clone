package com.estudos.twitter.data.repository

import android.util.Log
import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.DataUser
import com.estudos.twitter.data.service.UserService
import retrofit2.Response

class UserRespositoryImpl(
    private val service: UserService
) : UserRepository {

    override suspend fun getTwitterById(searchTwitter: String): Response<DataTweet> {
        var response: Response<DataTweet>
        var responseDataUser: Response<DataUser>

        return try {
            response = service.getTweets(searchTwitter)

            response.body()?.responseApi?.forEach {
                val authorId = it.author_id.toString()
                responseDataUser = service.getUserById(authorId)

                /*
                Confirmation of user data consumed by the API,
                but the insertion of data within the Tweet object
                is missing. Another consumption of user data was done on the details page.*/
                Log.e(
                    "${responseDataUser.body()?.user?.name}",
                    "${responseDataUser.body()?.user?.username}"
                )
            }

            response
        } catch (exception: Exception) {
            throw Exception(exception.message)
        }
    }

    override suspend fun getUserById(authorId: String): Response<DataUser> {
        var response: Response<DataUser>

        return try {
            response = service.getUserById(authorId)

            response
        } catch (exception: Exception) {
            throw Exception(exception.message)
        }

    }
}