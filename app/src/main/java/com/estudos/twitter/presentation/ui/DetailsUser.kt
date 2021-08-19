package com.estudos.twitter.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estudos.twitter.databinding.ActivityDetailsUserBinding
import com.estudos.twitter.presentation.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsUserBinding
    private val viewModel by viewModel<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val authorId = intent.getStringExtra("authorId") as String

        viewModel.getUser(authorId = authorId)

        viewModel.useLiveData.observe(this) {
            binding.tvName.text = it.user.name
            binding.tvLoginUser.text = it.user.username
        }
    }
}