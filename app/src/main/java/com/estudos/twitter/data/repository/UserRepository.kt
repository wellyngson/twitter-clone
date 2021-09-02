package com.estudos.twitter.data.repository

import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.DataUser

interface UserRepository {

    suspend fun getTwitterById(searchTwitter: String): DataTweet

    suspend fun getUserById(authorId: String): DataUser
}