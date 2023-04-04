package com.surivalcoding.imagesearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.surivalcoding.imagesearch.data.Photo
import com.surivalcoding.imagesearch.data.MockPhotoRepositoryImpl
import com.surivalcoding.imagesearch.data.PhotoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class MainUiState(
    val photos: List<Photo> = emptyList(),
    val isLoading: Boolean = false,
)

class MainViewModel(
    private val repository: PhotoRepository = MockPhotoRepositoryImpl()
) : ViewModel() {

    private var _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()

    fun onSearchButtonClick(query: String) {
        // 로딩
        _state.update {
            it.copy(
                photos = emptyList(),
                isLoading = true
            )
        }

        // 코루틴 스코프에서 오래걸리는 처리
        viewModelScope.launch {
            _state.update {
                it.copy(
                    photos = repository.searchPhotos(query),
                    isLoading = false,
                )
            }
        }
    }
}