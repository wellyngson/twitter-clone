package com.estudos.twitter.data.model

import com.google.gson.annotations.SerializedName

data class DataTweet(
    @SerializedName("data")
    val responseApi: List<Tweet>
)