package com.surivalcoding.imagesearch.data.repository

import com.surivalcoding.imagesearch.data.model.Photo
import com.surivalcoding.imagesearch.data.model.PhotoResult
import com.surivalcoding.imagesearch.data.remote.PhotoApi

class PixabayPhotoRepositoryImpl(
    private val api: PhotoApi
) : PhotoRepository {

    override suspend fun searchPhotos(query: String): List<Photo> {
        val result: PhotoResult = api.getPhotos(query = query)
        return result.hits
    }
}