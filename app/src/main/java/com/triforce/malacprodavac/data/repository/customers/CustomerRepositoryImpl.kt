package com.triforce.malacprodavac.data.repository.customers

import com.triforce.malacprodavac.data.local.MalacProdavacDatabase
import com.triforce.malacprodavac.data.remote.customers.CustomersApi
import com.triforce.malacprodavac.data.remote.customers.dto.CreateCustomerDto
import com.triforce.malacprodavac.domain.model.CreateCustomer
import com.triforce.malacprodavac.domain.model.Customer
import com.triforce.malacprodavac.domain.repository.CustomerRepository
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomerRepositoryImpl @Inject constructor(
    private val api: CustomersApi,
    private val db: MalacProdavacDatabase
):CustomerRepository {
    override suspend fun registerCustomer(
        createCustomer: CreateCustomer
    ): Flow<Resource<Customer>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val customer = try {
                api.registerCustomer(CreateCustomerDto(createCustomer.user)
                )
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't register user."))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't register user."))
                null
            }
            customer?.let {
//                authenticateUser(it)
//                dao.insertUser(listOf(it.user.toUserEntity()))
                 emit(Resource.Success(data = it))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

}