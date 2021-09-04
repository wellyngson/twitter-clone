package com.estudos.twitter.data.repository

import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.DataUser
import com.estudos.twitter.data.model.Tweet

interface UserRepository {

    suspend fun getTwitterById(searchTwitter: String): List<Tweet>

    suspend fun getUserById(authorId: String): DataUser
}