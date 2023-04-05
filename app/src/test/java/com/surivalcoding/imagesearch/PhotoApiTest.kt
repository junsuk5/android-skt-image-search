package com.surivalcoding.imagesearch

import com.surivalcoding.imagesearch.data.remote.PhotoApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.create
import org.junit.Assert.*
import retrofit2.converter.gson.GsonConverterFactory


class PhotoApiTest {

    @Test
    fun `이미지를 잘 가져온다`() = runBlocking {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: PhotoApi = retrofit.create()

        val result = service.getPhotos(query = "apple")
        assertEquals(9174, result.total)
        println(result)
    }
}