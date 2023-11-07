package com.triforce.malacprodavac.data.repository.users

import com.triforce.malacprodavac.data.local.MalacProdavacDatabase
import com.triforce.malacprodavac.data.mappers.toUser
import com.triforce.malacprodavac.data.remote.users.UsersApi
import com.triforce.malacprodavac.data.services.SessionManager
import com.triforce.malacprodavac.domain.model.User
import com.triforce.malacprodavac.domain.repository.UserRepository
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val api: UsersApi,
    private val db: MalacProdavacDatabase,
    private val sessionManager: SessionManager
): UserRepository {
    private val dao = db.userDao

    override suspend fun getUser(id: Int): Flow<Resource<User>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val user = try {
                val email = sessionManager.getCurrentEmail()
                dao.getUserForEmail(email!!).first()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't find user."))
                null
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't find user."))
                null
            }

            user?.let {
                emit(Resource.Success(data = user.toUser()))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

    override suspend fun getCurrentUser(): Flow<Resource<User>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val user = try {
                val email = sessionManager.getCurrentEmail()
                dao.getUserForEmail(email!!).first()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't find user."))
                null
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't find user."))
                null
            }

            user?.let {
                emit(Resource.Success(data = user.toUser()))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }
}
//
//
//    override suspend fun registerCourier(
//        createUser: CreateUser,
//        pricePerKilometer: Double
//    ): Flow<Resource<Courier>> {
//        return flow {
//            emit(Resource.Loading(isLoading = true))
//            val authResponse = try {
//                api.registerCouriers(
//                    CreateCourierDto(
//                        pricePerKilometer = pricePerKilometer,
//                         createUser = createUser
//                    )
//                )
//            } catch (e: IOException) {
//                e.printStackTrace()
//                emit(Resource.Error("Couldn't register user."))
//                null
//            } catch (e: HttpException) {
//                e.printStackTrace()
//                emit(Resource.Error("Couldn't register user."))
//                null
//            }
//            authResponse?.let {
//                authenticateUser(it)
//                dao.insertUser(listOf(it.user.toUserEntity()))
//                emit(Resource.Success(data = null)) // POPRAVITI OVAJ DEO
//            }
//            emit(Resource.Loading(isLoading = false))
//        }
//    }
//
//    override suspend fun registerShop(
//        createUser: CreateUser,
//        businessName: String
//    ): Flow<Resource<Shop>> {
//        return flow {
//            emit(Resource.Loading(isLoading = true))
//            val authResponse = try {
//                api.registerShops(
//                    CreateShopDto(
//                        createUser = createUser,
//                        businessName = businessName
//                    )
//                )
//            } catch (e: IOException) {
//                e.printStackTrace()
//                emit(Resource.Error("Couldn't register user."))
//                null
//            } catch (e: HttpException) {
//                e.printStackTrace()
//                emit(Resource.Error("Couldn't register user."))
//                null
//            }
//            authResponse?.let {
//                authenticateUser(it)
//                dao.insertUser(listOf(it.user.toUserEntity()))
//                emit(Resource.Success(data = null)) // POPRAVITI OVAJ DEO
//            }
//            emit(Resource.Loading(isLoading = false))
//        }
//    }


//    override suspend fun loginUser(
//        email: String,
//        password: String): Flow<Resource<User>> {
//        return flow {
//            emit(Resource.Loading(isLoading = true))
//            val authResponse = try {
//                api.loginUser(
//                    LoginDto(email, password)
//                )
//            } catch (e: IOException) {
//                e.printStackTrace()
//                emit(Resource.Error("Couldn't register user."))
//                null
//            } catch (e: HttpException) {
//                if(e.code() == 401)
//                    emit(Resource.Error(data=null, message = "Unauthenticated"))
//                else
//                    emit(Resource.Error(data=null, message = e.message()))
//                null
//            }
//            authResponse?.let {
//                authenticateUser(it)
//                dao.insertUser(listOf(it.user.toUserEntity()))
//                emit(Resource.Success(data = it.user.toUser()))
//                Log.d("LOGGED_IN", sessionManager.getAccessToken()+" "+sessionManager.getCurrentEmail())
//            }
//            emit(Resource.Loading(isLoading = false))
//        }


//    private fun authenticateUser(it: AuthenticationResponse) {
//        sessionManager.refreshToken(it.authToken.value) /// do refresh logic
//        sessionManager.setCurrentEmail(it.user.email)
//        sessionManager.setCurrentUserId(it.user.userId)
//    }


