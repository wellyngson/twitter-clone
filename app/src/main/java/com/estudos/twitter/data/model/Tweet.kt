package com.estudos.twitter.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Tweet(
    @PrimaryKey
    @SerializedName("id")
    val idTweet: Long,
    @SerializedName("text")
    val textTweet: String,
    @SerializedName("author_id")
    val idUser: Long,
    @SerializedName("public_metrics")
    @Embedded
    val complementsTweet: ComplementsTweet,
    var name: String,
    var username: String
) : Serializable