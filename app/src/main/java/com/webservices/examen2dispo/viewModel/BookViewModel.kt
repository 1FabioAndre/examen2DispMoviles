package com.webservices.examen2dispo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import com.webservices.usecases.SearchBooksUseCase
import com.webservices.domain.model.Book

@HiltViewModel
class BookViewModel @Inject constructor(
    private val searchBooksUseCase: SearchBooksUseCase
) : ViewModel() {

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun searchBooks(query: String) {
        _loading.value = true
        viewModelScope.launch {
            try {
                val result = searchBooksUseCase(query)
                _books.value = result
            } catch (e: Exception) {
                _books.value = emptyList()  // Si hay error, devolvemos lista vacía
            } finally {
                _loading.value = false
            }
        }
    }
}