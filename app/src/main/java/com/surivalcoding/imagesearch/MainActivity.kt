package com.surivalcoding.imagesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.core.view.isVisible
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

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val queryEditText = findViewById<EditText>(R.id.query_edit_text)

        findViewById<ImageButton>(R.id.search_button).setOnClickListener {
            viewModel.onSearchButtonClick(queryEditText.text.toString())
        }

        val adapter = PhotoAdapter()

        recyclerView.adapter = adapter

        viewModel.state.asLiveData().observe(this) { state ->
            progressBar.isVisible = state.isLoading

            adapter.submitList(state.photos)
        }
    }
}