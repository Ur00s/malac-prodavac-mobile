package com.triforce.malacprodavac.presentation.store

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triforce.malacprodavac.domain.model.Category
import com.triforce.malacprodavac.domain.repository.CategoryRepository
import com.triforce.malacprodavac.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {

    var state by mutableStateOf(StoreState())


    init{
        getCategories(true,null);
    }

    private fun getCategories( fetchFromRemote: Boolean,category: Category?) {
        viewModelScope.launch {
            repository.getCategories(fetchFromRemote).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        if (result.data is List<Category>) {
                            println(result.data)
                            println("WOHOOOOOOOOOOOOOOOOO!!!!!!!!!!!!!")
                            state = state.copy(categories = result.data)
                        }
                    }
                    is Resource.Error -> {
                        Unit
                    }

                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = result.isLoading
                        )
                    }
                }
            }

        }
    }
}