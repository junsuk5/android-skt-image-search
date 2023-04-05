package com.surivalcoding.imagesearch.data.remote

import com.surivalcoding.imagesearch.data.model.PhotoResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {

    @GET("api/?image_type=photo")
    suspend fun getPhotos(
        @Query("key") key: String = "10711147-dc41758b93b263957026bdadb",
        @Query("q") query: String,
    ): PhotoResult

    // static
    companion object {
        fun getInstance(): PhotoApi = Retrofit.Builder()
            .baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }
}