package com.triforce.malacprodavac.data.services

import android.content.SharedPreferences
import javax.inject.Inject

class AppSharedPreferences @Inject constructor(
    private val prefs: SharedPreferences
) {
    fun getToken(): String? =
        prefs.getString(TOKEN, null)


    fun setToken(token: String) =
        prefs.edit()
            .putString(TOKEN, token)
            .apply()

    fun removeToken() =
        prefs.edit()
            .remove(TOKEN)
            .apply()

    fun getRefreshToken(): String? =
        prefs.getString(REFRESH_TOKEN, null)

    fun setRefreshToken(refreshToken: String) =
        prefs.edit()
            .putString(REFRESH_TOKEN, refreshToken)
            .apply()

    fun removeRefreshToken() =
        prefs.edit()
            .remove(REFRESH_TOKEN)
            .apply()

    fun setUser(email: String) =
        prefs.edit()
            .putString(USER, email)
            .apply()

    fun getUser(): String? =
        prefs.getString(USER, null)

    fun removeUser() =
        prefs.edit()
            .remove(USER)
            .apply()

    fun getUserId(id: Int): Int =
        prefs.getInt(ID, -1)

    fun setUserId(id: Int) =
        prefs.edit()
            .putInt(ID, id)
            .apply()

    fun removeUserId() =
        prefs.edit()
            .remove(ID)
            .apply()


    companion object {
        const val REFRESH_TOKEN = "auth_token"
        const val TOKEN = "auth_token"
        const val USER = "auth_email"
        const val ID = "auth_user_id"
        const val SHARED_PREFS = "APP_SHARED_PREFS"
    }
}