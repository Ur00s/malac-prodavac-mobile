package com.triforce.malacprodavac.presentation.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triforce.malacprodavac.domain.model.Courier
import com.triforce.malacprodavac.domain.model.CreateCourier
import com.triforce.malacprodavac.domain.model.CreateCustomer
import com.triforce.malacprodavac.domain.model.CreateShop
import com.triforce.malacprodavac.domain.model.CreateUser
import com.triforce.malacprodavac.domain.model.Customer
import com.triforce.malacprodavac.domain.model.Shop
import com.triforce.malacprodavac.domain.repository.CourierRepository
import com.triforce.malacprodavac.domain.repository.CustomerRepository
import com.triforce.malacprodavac.domain.repository.ShopRepository
import com.triforce.malacprodavac.domain.use_case.ValidateEmail
import com.triforce.malacprodavac.domain.use_case.ValidateFirstName
import com.triforce.malacprodavac.domain.use_case.ValidateLastName
import com.triforce.malacprodavac.domain.use_case.ValidatePassword
import com.triforce.malacprodavac.domain.use_case.ValidateRepeatedPassword
import com.triforce.malacprodavac.domain.use_case.ValidateTerms
import com.triforce.malacprodavac.util.AuthResult
import com.triforce.malacprodavac.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    //private val savedStateHandle: SavedStateHandle,
    private val customersRepository: CustomerRepository,
    private val couriersRepository: CourierRepository,
    private val shopsRepository: ShopRepository,
) : ViewModel() {

    private val valiStringFirstName: ValidateFirstName = ValidateFirstName()
    private val valiStringLastName: ValidateLastName = ValidateLastName()
    private val valiStringEmail: ValidateEmail = ValidateEmail()
    private val valiStringPassword: ValidatePassword = ValidatePassword()
    private val valiStringRepeatedPassword: ValidateRepeatedPassword =
        ValidateRepeatedPassword()
    private val valiStringTerms: ValidateTerms = ValidateTerms()
    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()
    var hasError = false

    fun onEvent(event: RegistrationFormEvent) {
        when (event) {
            is RegistrationFormEvent.FirstNameChanged -> {
                state = state.copy(firstName = event.firstName)
            }

            is RegistrationFormEvent.LastNameChanged -> {
                state = state.copy(lastName = event.lastName)
            }

            is RegistrationFormEvent.RoleChanged -> {
                state = state.copy(role = event.role)
            }

            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is RegistrationFormEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }

            is RegistrationFormEvent.AcceptTermsChanged -> {
                state = state.copy(acceptedTerms = event.isAccepted)
            }

            is RegistrationFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val firstNameResult = valiStringFirstName.execute(state.firstName)
        val lastNameResult = valiStringLastName.execute(state.lastName)
        val emailResult = valiStringEmail.execute(state.email)
        val passwordResult = valiStringPassword.execute(state.password)
        val repeatedPasswordResult = valiStringRepeatedPassword.execute(
            state.password, state.repeatedPassword
        )
        val termsResult = valiStringTerms.execute(state.acceptedTerms)
        val firstName = state.firstName
        val lastName = state.lastName
        val email = state.email
        val password = state.password
        val createUser = CreateUser(
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password
        )

        hasError = listOf(
            firstNameResult,
            lastNameResult,
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult
        ).any { !it.successful }


        if (!hasError) {
            when (state.role) {
                "KUPAC" -> registerCustomer(CreateCustomer(createUser))
                "DOSTAVLJAČ" -> registerCourier(CreateCourier(createUser, 0.0))
                else -> registerShop(CreateShop(createUser, ""))
            }
        }

        if (hasError) {
            state = state.copy(
                firstNameError = firstNameResult.errorMessage,
                lastNameError = lastNameResult.errorMessage,
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termsResult.errorMessage
            )
            return
        }

        viewModelScope.launch {
            state = state.copy(
                firstNameError = "",
                lastNameError = "",
                emailError = "",
                passwordError = "",
                repeatedPasswordError = "",
                termsError = ""
            )
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    private fun registerCustomer(createCustomer: CreateCustomer) {
        viewModelScope.launch {
            customersRepository.registerCustomer(createCustomer)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            if (result.data !is Customer) {
                                state = state.copy(
                                    status = AuthResult.Unauthorized()
                                )
                            }
                            if (result.data is Customer) {
                                state = state.copy(
                                    status = AuthResult.Authorized(state.email)
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

    private fun registerCourier(createCourier: CreateCourier) {
        viewModelScope.launch {
            couriersRepository.registerCourier(createCourier)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            if (result.data !is Courier) {
                                state = state.copy(
                                    status = AuthResult.Unauthorized()
                                )
                            }
                            if (result.data is Courier) {
                                state = state.copy(
                                    status = AuthResult.Authorized(state.email)
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

    private fun registerShop(createShop: CreateShop) {
        viewModelScope.launch {
            shopsRepository.registerShop(createShop)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            if (result.data !is Shop) {
                                state = state.copy(
                                    status = AuthResult.Unauthorized()
                                )
                            }
                            if (result.data is Shop) {
                                state = state.copy(
                                    status = AuthResult.Authorized(state.email)
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
        object Success : ValidationEvent()
    }
}