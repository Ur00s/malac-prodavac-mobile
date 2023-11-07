package com.triforce.malacprodavac.domain.repository

import com.triforce.malacprodavac.domain.model.User
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUser(id: Int): Flow<Resource<User>>

    suspend fun getCurrentUser(): Flow<Resource<User>>
}
