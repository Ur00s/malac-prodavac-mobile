package com.triforce.malacprodavac.presentation.store

import com.triforce.malacprodavac.domain.model.Category


data class StoreState(
    val categories: List<Category> = emptyList(),
    val subCategories: List<Category>? = emptyList(),
    val isLoading:Boolean = false
)
