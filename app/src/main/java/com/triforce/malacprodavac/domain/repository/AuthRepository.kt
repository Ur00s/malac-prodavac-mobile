package com.triforce.malacprodavac.domain.repository

import com.triforce.malacprodavac.domain.model.User
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(
        email: String,
        password: String
    ): Flow<Resource<User>>
}