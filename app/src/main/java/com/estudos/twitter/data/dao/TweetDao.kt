package com.estudos.twitter.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.Tweet

@Dao
interface TweetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(tweet: Tweet)

    @Query("SELECT * FROM Tweet")
    fun getAll(): List<Tweet>
}
