package com.estudos.twitter.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tweet(
    @SerializedName("id")
    val idTweet: Long,
    @SerializedName("text")
    val textTweet: String,
    @SerializedName("author_id")
    val idUser: Long,
    @SerializedName("public_metrics")   
    val complementsTweet: ComplementsTweet,
    val dataUser: DataUser
) : Serializable