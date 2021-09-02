package com.estudos.twitter.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataTweet(
    @SerializedName("data")
    val listTweets: List<Tweet>
) : Serializable