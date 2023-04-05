package com.surivalcoding.imagesearch.data.repository

import com.surivalcoding.imagesearch.data.model.Photo
import kotlinx.coroutines.delay

class MockPhotoRepositoryImpl : PhotoRepository {
    private val items = listOf(
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

    override suspend fun searchPhotos(query: String) : List<Photo> {
        delay(2000)

        return items
    }
}