package com.triforce.malacprodavac.data.repository.couriers

import com.triforce.malacprodavac.data.local.MalacProdavacDatabase
import com.triforce.malacprodavac.data.remote.couriers.CouriersApi
import com.triforce.malacprodavac.data.remote.couriers.dto.CreateCourierDto
import com.triforce.malacprodavac.domain.model.Courier
import com.triforce.malacprodavac.domain.model.CreateCourier
import com.triforce.malacprodavac.domain.repository.CourierRepository
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CourierRepositoryImpl @Inject constructor(
    private val api: CouriersApi,
    private val db: MalacProdavacDatabase
):CourierRepository {
    override suspend fun registerCourier(
        createCourier: CreateCourier
    ): Flow<Resource<Courier>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val courier = try {
                api.registerCouriers(
                    CreateCourierDto(createCourier.user,  createCourier.pricePerKilometer)
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
            courier?.let {
//                authenticateUser(it)
//                dao.insertUser(listOf(it.user.toUserEntity()))
                emit(Resource.Success(data = it))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

}