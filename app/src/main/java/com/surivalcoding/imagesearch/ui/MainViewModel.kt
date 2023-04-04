package com.surivalcoding.imagesearch.ui

import androidx.lifecycle.ViewModel
import com.surivalcoding.imagesearch.data.Photo
import com.surivalcoding.imagesearch.data.PhotoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class MainUiState(
    val photos: List<Photo> = emptyList(),
)

class MainViewModel : ViewModel() {
    private val repository = PhotoRepository()

    private var _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(photos = repository.searchPhotos("apple"))
        }
    }

    fun onSearchButtonClick(query: String) {

    }
}