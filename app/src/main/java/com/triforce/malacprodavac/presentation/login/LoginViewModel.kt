package com.triforce.malacprodavac.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triforce.malacprodavac.data.services.SessionManager
import com.triforce.malacprodavac.domain.model.User
import com.triforce.malacprodavac.domain.repository.AuthRepository
import com.triforce.malacprodavac.domain.use_case.ValidateEmail
import com.triforce.malacprodavac.domain.use_case.ValidatePassword
import com.triforce.malacprodavac.util.AuthResult
import com.triforce.malacprodavac.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val sessionManager: SessionManager
): ViewModel() {

    private val ValidateEmail: ValidateEmail = ValidateEmail()
    private val ValidatePassword: ValidatePassword = ValidatePassword()
    var state by mutableStateOf(LoginFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()
    var hasError = false

    fun isUserAuthenticated(): Boolean {
        if(sessionManager.getAccessToken() != null)
            return true
        return false
    }

    fun onEvent(event: LoginFormEvent) {
        when(event) {
            is LoginFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is LoginFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is LoginFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = ValidateEmail.execute(state.email)
        val passwordResult = ValidatePassword.execute(state.password)

        hasError = listOf(
            emailResult,
            passwordResult
        ).any { !it.successful }

        if(!hasError) {
            loginUser(state.email, state.password)
        }

        if(hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )
            return
        }

        viewModelScope.launch {
            state = state.copy(
                emailError = "",
                passwordError = ""
            )
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    private fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            repository.login(email, password)
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            if (result.data !is User){
                                state = state.copy(
                                    status = AuthResult.Unauthorized()
                                )
                            }
                            if (result.data is User) {
                                state = state.copy(
                                    status = AuthResult.Authorized(result.data.email)
                                )
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

    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
}