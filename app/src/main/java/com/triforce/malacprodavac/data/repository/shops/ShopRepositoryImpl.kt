package com.triforce.malacprodavac.data.repository.shops

import com.triforce.malacprodavac.data.local.MalacProdavacDatabase
import com.triforce.malacprodavac.data.remote.shops.ShopsApi
import com.triforce.malacprodavac.data.remote.shops.dto.CreateShopDto
import com.triforce.malacprodavac.domain.model.CreateShop
import com.triforce.malacprodavac.domain.model.Shop
import com.triforce.malacprodavac.domain.repository.ShopRepository
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopRepositoryImpl @Inject constructor(
    private val api: ShopsApi,
    private val db: MalacProdavacDatabase
):ShopRepository {
    override suspend fun registerShop(
        createShop: CreateShop
    ): Flow<Resource<Shop>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val shop = try {
                api.registerShop(
                    CreateShopDto(createShop.user, createShop.businessName)
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
            shop?.let {
//                authenticateUser(it)
//                dao.insertUser(listOf(it.user.toUserEntity()))
                emit(Resource.Success(data = it))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

}