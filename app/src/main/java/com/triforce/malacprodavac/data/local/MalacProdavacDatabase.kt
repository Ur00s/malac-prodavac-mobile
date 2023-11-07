package com.triforce.malacprodavac.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.triforce.malacprodavac.data.local.category.CategoryDao
import com.triforce.malacprodavac.data.local.category.CategoryEntity
import com.triforce.malacprodavac.data.local.user.UserDao
import com.triforce.malacprodavac.data.local.user.UserEntity

@Database(
    entities = [
        UserEntity::class,
        CategoryEntity::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(RoomConverters::class)
abstract class MalacProdavacDatabase: RoomDatabase() {
    abstract val userDao: UserDao
    abstract val categoryDao: CategoryDao
}