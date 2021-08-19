package com.estudos.twitter.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tweet(
    val id: Long,
    val text: String,
    val author_id: Long,
    @SerializedName("public_metrics") val complementsTweet: ComplementsTweet,
    val dataUser: DataUser
) : Serializable