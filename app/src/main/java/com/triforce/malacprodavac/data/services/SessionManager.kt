package com.triforce.malacprodavac.data.services

import javax.inject.Inject

class SessionManager @Inject constructor(
    private val pref: AppSharedPreferences
) {
    fun getAccessToken(): String? = pref.getToken()

    fun getRefreshToken(): String? = pref.getRefreshToken()

    fun refreshToken(refreshToken: String): String {
        pref.setRefreshToken(refreshToken)
        return refreshToken
    }//authRepository.refreshToken(refreshToken)

    fun getCurrentEmail(): String? =
        pref.getUser()

    fun setCurrentEmail(email: String) =
        pref.setUser(email)

    fun getCurrentUserId(id: Int) =
        pref.getUserId(id)

    fun setCurrentUserId(id: Int) =
        pref.setUserId(id)

    fun logout() {
        pref.removeToken()
        pref.removeRefreshToken()
        pref.removeUser()
        pref.removeUserId()
    }
}