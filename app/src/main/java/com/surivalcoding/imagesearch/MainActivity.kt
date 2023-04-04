package com.surivalcoding.imagesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.surivalcoding.imagesearch.ui.MainViewModel
import com.surivalcoding.imagesearch.ui.PhotoAdapter

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val adapter = PhotoAdapter()

        recyclerView.adapter = adapter

        viewModel.state.asLiveData().observe(this) { state ->
            adapter.submitList(state.photos)
        }
    }
}