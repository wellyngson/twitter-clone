package com.estudos.twitter.data.model

import java.io.Serializable

data class ComplementsTweet(
    val retweet_count: Int,
    val reply_count: Int,
    val like_count: Int,
    val quote_count: Int
) : Serializable