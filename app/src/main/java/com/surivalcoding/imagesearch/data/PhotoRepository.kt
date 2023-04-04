package com.surivalcoding.imagesearch.data

interface PhotoRepository {

    fun searchPhotos(query: String): List<Photo>
}