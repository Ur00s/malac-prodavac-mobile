package com.triforce.malacprodavac.domain.repository

import com.triforce.malacprodavac.domain.model.CreateCustomer
import com.triforce.malacprodavac.domain.model.Customer
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {
    suspend fun registerCustomer(
        createCustomer: CreateCustomer
    ): Flow<Resource<Customer>>
}
