package com.triforce.malacprodavac.data.local.category

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CategoryDao {

    @Query("SELECT * FROM CategoryEntity")
    suspend fun  getAllCategories(): List<CategoryEntity>

    @Query("""SELECT * FROM CategoryEntity
        WHERE id = :id""")
    suspend fun getCategoryForId(id: Int): List<CategoryEntity>

    @Query("""SELECT * FROM CategoryEntity
        WHERE parentCategoryId = :parentCategoryId""")
    suspend fun getCategoryForParentId(parentCategoryId: Int): List<CategoryEntity>

    @Query("DELETE FROM CategoryEntity")
    suspend fun clearCategories()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categories: List<CategoryEntity>)
}