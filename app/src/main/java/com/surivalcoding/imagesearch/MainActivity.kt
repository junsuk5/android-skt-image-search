package com.surivalcoding.imagesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.surivalcoding.imagesearch.data.Photo
import com.surivalcoding.imagesearch.ui.PhotoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val adapter = PhotoAdapter()

        recyclerView.adapter = adapter

        val items = listOf(
            Photo(
                id = 0,
                previewURL = "https://cdnimg.melon.co.kr/cm2/artistcrop/images/002/61/143/261143_20210325180240_org.jpg?61e575e8653e5920470a38d1482d7312/melon/optimize/90",
                tags = "아이유, 여신"
            ),
            Photo(
                id = 1,
                previewURL = "https://image.bugsm.co.kr/album/images/500/40271/4027185.jpg",
                tags = "아이유, 가수"
            ),
            Photo(
                id = 2,
                previewURL = "https://img.gqkorea.co.kr/gq/2022/08/style_63073140eea70.jpg",
                tags = "아이유, 연기자"
            ),
        )

        adapter.submitList(items)
    }
}