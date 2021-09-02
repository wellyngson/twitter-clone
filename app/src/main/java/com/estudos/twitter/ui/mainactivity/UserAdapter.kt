package com.estudos.twitter.ui.mainactivity

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.estudos.twitter.R
import com.estudos.twitter.data.model.Tweet
import com.estudos.twitter.databinding.ItemTwitterBinding
import com.estudos.twitter.ui.detailsuser.DetailsUser

class UserAdapter : ListAdapter<Tweet, UserAdapter.UserViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.item_twitter, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindViewHolder(getItem(position))
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ItemTwitterBinding = ItemTwitterBinding.bind(itemView)

        fun bindViewHolder(tweet: Tweet) {
            binding.tvDescription.text = tweet.textTweet
            binding.tvNumberLike.text = tweet.complementsTweet.likeCount.toString()
            binding.tvNumberRetwetar.text = tweet.complementsTweet.retweetCount.toString()
            binding.tvNumberComment.text = tweet.complementsTweet.quoteCount.toString()

            itemView.setOnClickListener {
                val intent = Intent(it.context, DetailsUser::class.java).apply {
                    putExtra("authorId", tweet.idUser.toString())
                }
                it.context.startActivity(intent)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Tweet>() {
    override fun areItemsTheSame(oldItem: Tweet, newItem: Tweet) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Tweet, newItem: Tweet) = oldItem.idTweet == newItem.idTweet
}