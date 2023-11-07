package com.triforce.malacprodavac.data.remote.auth

import com.triforce.malacprodavac.data.remote.auth.dto.LoginDto
import com.triforce.malacprodavac.domain.model.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("${ROUTE}/login")
    suspend fun login(
        @Body loginRequest: LoginDto
    ): User

    companion object {
        const val ROUTE = "/auth"
    }
}