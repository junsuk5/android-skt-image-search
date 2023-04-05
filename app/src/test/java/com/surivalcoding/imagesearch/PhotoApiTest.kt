package com.surivalcoding.imagesearch

import com.surivalcoding.imagesearch.data.remote.PhotoApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


class PhotoApiTest {

    @Test
    fun `이미지를 잘 가져온다`() = runBlocking {

        val service: PhotoApi = PhotoApi.getInstance()

        val result = service.getPhotos(query = "apple")
        assertEquals(9174, result.total)
        println(result)
    }
}