package com.triforce.malacprodavac.domain.use_case.category

import kotlinx.coroutines.Job

data class CategoryUseCases(
    var getCategories: GetAllCategories,
    var getCategory: GetCategory
)
