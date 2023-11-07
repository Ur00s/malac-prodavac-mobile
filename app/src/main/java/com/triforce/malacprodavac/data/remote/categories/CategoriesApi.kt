package com.triforce.malacprodavac.data.remote.categories

import com.triforce.malacprodavac.data.local.category.CategoryEntity
import com.triforce.malacprodavac.data.remote.dto.PaginationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoriesApi {

    @GET(ROUTE)
    suspend fun getAllCategories(): PaginationResponse

    @GET("${ROUTE}/{id}")
    suspend fun getCategoryForId(
        @Path("id") categoryId: Int
    ): CategoryEntity

    @GET(ROUTE)
    suspend fun getSubCategoriesForParentId(
        @Query("filter[0][field]") field: String,
        @Query("filter[0][type]") type: String,
        @Query("filter[0][value]") value: Int,
    ): List<CategoryEntity>


    companion object {
        const val ROUTE = "/categories"
    }
}