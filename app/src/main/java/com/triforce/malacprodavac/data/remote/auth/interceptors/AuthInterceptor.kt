package com.triforce.malacprodavac.data.remote.auth.interceptors

import android.util.Log
import com.triforce.malacprodavac.data.services.SessionManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.net.HttpURLConnection
import javax.inject.Inject

class AuthInterceptorImpl @Inject constructor(
    private val sessionManager: SessionManager
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var authToken = sessionManager.getAccessToken()

        val response = chain.proceed(newRequestWithAuthToken(authToken, request))
        Log.d("INTERCEPTOR", authToken.toString())
        if(response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
            Log.d("UNATHORIZED","HTTP_UNAUTHORIZED")
            val newAuthToken = sessionManager.getAccessToken()
            if(newAuthToken != authToken) {
                return chain.proceed(newRequestWithAuthToken(authToken, request))
            } else {
                authToken = refreshToken()
                if(authToken.isNullOrBlank()) {
                    sessionManager.logout()
                    return response
                }
                return chain.proceed(newRequestWithAuthToken(authToken, request))
            }
        }
        Log.d("AUTHORIZED", "HTTP_AUTHORIZED")
        return response
    }



    private fun newRequestWithAuthToken(authToken: String?, request: Request): Request =
        request.newBuilder()
            .header("Authentication", "$authToken")
            .build()

    private fun refreshToken(): String? {
        synchronized(this) {
            val refreshToken = sessionManager.getRefreshToken()
            refreshToken?.let {
                return sessionManager.refreshToken(refreshToken)
            } ?: return null
        }
    }
}