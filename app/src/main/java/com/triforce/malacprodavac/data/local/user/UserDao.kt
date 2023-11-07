package com.triforce.malacprodavac.data.local.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    suspend fun getUsers(): List<UserEntity>

    @Query("""SELECT * FROM UserEntity
                WHERE id = :id""")
    suspend fun getUserForId(id: Int): List<UserEntity>

    @Query("""SELECT * FROM UserEntity
        WHERE email = :email""")
    suspend fun getUserForEmail(email: String): List<UserEntity>

    @Query("DELETE FROM UserEntity")
    suspend fun clearUsers()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(users: List<UserEntity>)
}