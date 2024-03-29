package com.surivalcoding.imagesearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.imagesearch.data.repository.MockPhotoRepositoryImpl
import com.surivalcoding.imagesearch.data.model.Photo
import com.surivalcoding.imagesearch.data.remote.PhotoApi
import com.surivalcoding.imagesearch.data.repository.PhotoRepository
import com.surivalcoding.imagesearch.data.repository.PixabayPhotoRepositoryImpl
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class MainUiState(
    val photos: List<Photo> = emptyList(),
    val isLoading: Boolean = false,
)

class MainViewModel(
    private val repository: PhotoRepository
        = PixabayPhotoRepositoryImpl(PhotoApi.getInstance())
//        = MockPhotoRepositoryImpl()
) : ViewModel() {

    private var _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()

    private var job: Job? = null

    fun onSearchButtonClick(query: String) {
        // 로딩
        _state.update {
            it.copy(
                photos = emptyList(),
                isLoading = true
            )
        }

        job?.cancel()
        // 코루틴 스코프에서 오래걸리는 처리
        job = viewModelScope.launch {
            _state.update {
                it.copy(
                    photos = repository.searchPhotos(query),
                    isLoading = false,
                )
            }
        }
    }
}