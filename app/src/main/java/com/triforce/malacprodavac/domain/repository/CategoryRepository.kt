package com.triforce.malacprodavac.domain.repository

import com.triforce.malacprodavac.domain.model.Category
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun getCategories(fetchFromRemote: Boolean): Flow<Resource<List<Category>>>
    suspend fun getCategorie(id: Int, fetchFromRemote: Boolean): Flow<Resource<List<Category>>>
    suspend fun getSubCategories(id: Int, fetchFromRemote: Boolean): Flow<Resource<List<Category>>>
}