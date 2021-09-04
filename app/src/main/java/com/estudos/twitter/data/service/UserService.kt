package com.estudos.twitter.data.service

import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.DataUser
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {

    @GET("tweets/search/recent?&tweet.fields=author_id,public_metrics")
    suspend fun getTweets(@Query("query") query: String): DataTweet

    @GET("users/{authorId}")
    suspend fun getUserById(@Path("authorId") authorId: String): DataUser
}