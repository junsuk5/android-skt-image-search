package com.surivalcoding.imagesearch.data

interface PhotoRepository {

    suspend fun searchPhotos(query: String): List<Photo>
}