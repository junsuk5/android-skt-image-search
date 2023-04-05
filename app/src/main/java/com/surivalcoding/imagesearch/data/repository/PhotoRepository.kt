package com.surivalcoding.imagesearch.data.repository

import com.surivalcoding.imagesearch.data.model.Photo

interface PhotoRepository {

    suspend fun searchPhotos(query: String): List<Photo>
}