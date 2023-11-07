package com.triforce.malacprodavac.presentation.registration

import com.triforce.malacprodavac.util.AuthResult

data class RegistrationFormState (
    val firstName: String = "",
    val firstNameError: String? = null,
    val lastName: String = "",
    val lastNameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val repeatedPassword: String = "",
    val repeatedPasswordError: String? = null,
    val role: String = "",
    val isLoading: Boolean = false,
    val acceptedTerms: Boolean = false,
    val termsError: String? = null,
    val status: AuthResult<String> = AuthResult.Unauthorized()
)