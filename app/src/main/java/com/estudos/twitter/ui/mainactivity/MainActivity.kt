package com.estudos.twitter.ui.mainactivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudos.twitter.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { UserAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        setupAdapter()
        insertListeners()
        setupObservables()
    }

    private fun setupAdapter() {
        binding.rvRecyclerView.adapter = adapter
        binding.rvRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun insertListeners() {
        binding.fbFloatingButton.setOnClickListener {
            if (binding.tietSearch.text != null) {
                viewModel.init("covid")
            } else {
                Toast.makeText(
                    this,
                    "Insira algum tema",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun setupObservables() {
        viewModel.listTweet.observe(this, {
            adapter.submitList(it)
        })
    }
}