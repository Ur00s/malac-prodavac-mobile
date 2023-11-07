package com.triforce.malacprodavac.data.remote.customers


import com.triforce.malacprodavac.data.remote.customers.dto.CreateCustomerDto
import com.triforce.malacprodavac.domain.model.Customer
import retrofit2.http.Body
import retrofit2.http.POST

interface CustomersApi {
    @POST(ROUTE)
    suspend fun registerCustomer(
        @Body registerRequest: CreateCustomerDto
    ): Customer

    companion object{
        const val ROUTE = "/customers"
    }
}