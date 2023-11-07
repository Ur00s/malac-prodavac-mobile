package com.triforce.malacprodavac.presentation.login

import com.triforce.malacprodavac.util.AuthResult

data class LoginFormState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val status: AuthResult<String> = AuthResult.Unauthorized()
)
