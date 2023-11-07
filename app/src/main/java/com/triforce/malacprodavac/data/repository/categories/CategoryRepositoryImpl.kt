package com.triforce.malacprodavac.data.repository.categories

import com.triforce.malacprodavac.data.local.MalacProdavacDatabase
import com.triforce.malacprodavac.data.mappers.toCategory
import com.triforce.malacprodavac.data.remote.categories.CategoriesApi
import com.triforce.malacprodavac.data.services.SessionManager
import com.triforce.malacprodavac.domain.model.Category
import com.triforce.malacprodavac.domain.repository.CategoryRepository
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepositoryImpl @Inject constructor(
    private val api: CategoriesApi,
    private val db: MalacProdavacDatabase,
    private val sessionManager: SessionManager
) : CategoryRepository {
    private val dao = db.categoryDao
    override suspend fun getCategories(fetchFromRemote: Boolean): Flow<Resource<List<Category>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val localCategories = dao.getAllCategories()
            emit(Resource.Success(
                data = localCategories.map { it.toCategory() }
            ))

            val isDbEmpty = localCategories.isEmpty()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) { //we already returned an emit with Resource.Success<data from cache>
                emit(Resource.Loading(false)) // stop loading indication
                return@flow
            }
            val remoteCategories = try {
                api.getAllCategories()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load categories."))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load category data"))
                null
            }
            remoteCategories?.let {
                println(remoteCategories.data)
                emit(Resource.Success(remoteCategories.data.map { it.toCategory() }))
            }
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getCategorie(
        id: Int,
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Category>>> {
        return flow {
            emit(Resource.Loading(true))
            val localCategory = dao.getCategoryForId(id)
            emit(Resource.Success(
                data = localCategory.map { it.toCategory() }
            ))

            val isDbEmpty = localCategory.isEmpty()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) { //we already returned an emit with Resource.Success<data from cache>
                emit(Resource.Loading(false)) //stop loading indication
                return@flow
            }
            val remoteCategory = try {
                api.getCategoryForId(id)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load post data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load post data"))
                null
            }
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getSubCategories(
        id: Int,
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Category>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val localCategories = dao.getCategoryForParentId(id)
            emit(Resource.Success(
                data = localCategories.map { it.toCategory() }
            ))

            val isDbEmpty = localCategories.isEmpty()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) { //we already returned an emit with Resource.Success<data from cache>
                emit(Resource.Loading(false)) // stop loading indication
                return@flow
            }
            val remoteCategories = try {
                api.getSubCategoriesForParentId("parentCategoryId", "=", id)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load category data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load category data"))
                null
            }
            emit(Resource.Loading(false))
        }
    }


}