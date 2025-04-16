package com.webservices.examen2dispo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import com.webservices.usecases.SearchBooksUseCase
import com.webservices.domain.model.Book
import androidx.compose.runtime.mutableStateOf


@HiltViewModel
class BookViewModel @Inject constructor(
    private val searchBooksUseCase: SearchBooksUseCase
) : ViewModel() {

    // Cambiar esto a una propiedad de tipo MutableState
    private val _searchQuery = mutableStateOf("")

    // Hacer que searchQuery sea un getter para el estado
    val searchQuery: String get() = _searchQuery.value

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    // Esta función permite modificar el valor de searchQuery desde la UI
    fun onSearchQueryChange(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun searchBooks(query: String) {
        _loading.value = true
        viewModelScope.launch {
            try {
                val result = searchBooksUseCase(query)
                _books.value = result
            } catch (e: Exception) {
                _books.value = emptyList()
            } finally {
                _loading.value = false
            }
        }
    }
}