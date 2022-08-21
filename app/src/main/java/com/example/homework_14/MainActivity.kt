package com.example.homework_14

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_14.adapter.MainAdapter
import com.example.homework_14.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val itemAdapter = MainAdapter()

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        observers()

    }

    private fun init() {
        binding.root.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observers() {
        lifecycleScope.launch {
            viewModel.getItems().collect {
                when (it) {
                    is Result.Success -> {
                        itemAdapter.submitList(it.list)
                    }

                    is Result.Error -> {
                        Toast.makeText(this@MainActivity, it.errorMsg, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}