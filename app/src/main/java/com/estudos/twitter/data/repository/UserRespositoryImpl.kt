package com.estudos.twitter.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.estudos.twitter.core.Utils
import com.estudos.twitter.data.dao.TweetDao
import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.DataUser
import com.estudos.twitter.data.model.Tweet
import com.estudos.twitter.data.service.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRespositoryImpl(
    private val context: Context,
    private val service: UserService,
    private val dao: TweetDao
) : UserRepository {

    override suspend fun getTwitterById(searchTwitter: String): List<Tweet> {
        var responseListTweets: DataTweet
        var dataUser: DataUser
        var listTweet: MutableList<Tweet> = mutableListOf()

        if (Utils.isOnline(context)) {
            return try {
                withContext(Dispatchers.IO) {
                    responseListTweets = service.getTweets(searchTwitter)
                }

                responseListTweets.listTweets.forEach {
                    withContext(Dispatchers.IO) {
                        dataUser = service.getUserById(it.idUser.toString())
                    }

                    it.name = dataUser.user.name
                    it.username = dataUser.user.username

                    withContext(Dispatchers.IO) {
                        listTweet.add(it)
                        dao.save(it)
                    }
                }

                listTweet
            } catch (exception: Exception) {
                throw Exception(exception.message)
            }
        } else {
            Toast.makeText(context, "Sem internet", Toast.LENGTH_LONG).show()
            return withContext(Dispatchers.IO) {
                dao.getAll()
            }
        }
    }

    override suspend fun getUserById(authorId: String): DataUser {
        TODO("Not yet implemented")
    }
}