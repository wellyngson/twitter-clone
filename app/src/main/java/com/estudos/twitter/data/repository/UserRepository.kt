package com.estudos.twitter.data.repository

import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.DataUser
import retrofit2.Response

interface UserRepository {

    suspend fun getTwitterById(searchTwitter: String): Response<DataTweet>

    suspend fun getUserById(authorId: String): Response<DataUser>
}