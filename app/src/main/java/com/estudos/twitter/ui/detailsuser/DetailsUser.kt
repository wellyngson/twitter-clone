package com.estudos.twitter.ui.detailsuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estudos.twitter.data.model.Tweet
import com.estudos.twitter.databinding.ActivityDetailsUserBinding

class DetailsUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsUserBinding
//    private val viewModel by viewModel<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val singleTweet = intent.getSerializableExtra("singleTweet") as Tweet
        binding.tvName.text = singleTweet.name
        binding.tvLoginUser.text = singleTweet.username

//        viewModel.getUser(authorId = authorId)

//        viewModel.useLiveData.observe(this) {
//            binding.tvName.text = it.user.name
//            binding.tvLoginUser.text = it.user.username
//        }
    }
}