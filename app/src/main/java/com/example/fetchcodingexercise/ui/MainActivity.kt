package com.example.fetchcodingexercise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchcodingexercise.adapter.ItemListAdapter
import com.example.fetchcodingexercise.databinding.ActivityMainBinding
import com.example.fetchcodingexercise.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemListAdapter = ItemListAdapter(emptyList())
        binding.rvItems.layoutManager = LinearLayoutManager(this)
        binding.rvItems.adapter = itemListAdapter

        viewModel.fetchData()
        viewModel.itemLiveData.observe(this) {
            itemListAdapter.updateData(it)
        }
    }
}