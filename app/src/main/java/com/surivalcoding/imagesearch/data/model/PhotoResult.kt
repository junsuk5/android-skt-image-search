package com.surivalcoding.imagesearch.data.model

data class PhotoResult(
    val total: Int,
    val totalHits: Int,
    val hits: List<Photo>,
)