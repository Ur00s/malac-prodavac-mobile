package com.triforce.malacprodavac.domain.use_case.category

import com.triforce.malacprodavac.domain.model.Category
import com.triforce.malacprodavac.domain.repository.CategoryRepository
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow

class GetAllCategories(
    private val repository: CategoryRepository
) {

    suspend operator fun invoke(
    ): Flow<Resource<List<Category>>> {
        return repository.getCategories(false)
    }

}