package com.triforce.malacprodavac.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.triforce.malacprodavac.data.local.MalacProdavacDatabase
import com.triforce.malacprodavac.data.local.RoomConverters
import com.triforce.malacprodavac.data.remote.Api
import com.triforce.malacprodavac.data.remote.auth.AuthApi
import com.triforce.malacprodavac.data.remote.auth.interceptors.AuthInterceptorImpl
import com.triforce.malacprodavac.data.remote.categories.CategoriesApi
import com.triforce.malacprodavac.data.remote.couriers.CouriersApi
import com.triforce.malacprodavac.data.remote.customers.CustomersApi
import com.triforce.malacprodavac.data.remote.shops.ShopsApi
import com.triforce.malacprodavac.data.remote.users.UsersApi
import com.triforce.malacprodavac.data.services.AppSharedPreferences
import com.triforce.malacprodavac.data.services.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder().add(
            KotlinJsonAdapterFactory()
        ).build()


    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder().baseUrl(Api.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi)).build()


    /*  USER API DEPENDENCY CHAIN */

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi =
        retrofit.create()

    @Provides
    @Singleton
    fun provideUsersApi(retrofit: Retrofit): UsersApi =
        retrofit.create()


    @Provides
    @Singleton
    fun provideCustomersApi(retrofit: Retrofit): CustomersApi =
        retrofit.create()

    @Provides
    @Singleton
    fun provideCategoriesApi(retrofit: Retrofit): CategoriesApi =
        retrofit.create()

    @Provides
    @Singleton
    fun provideCouriersApi(retrofit: Retrofit): CouriersApi = retrofit.create()


    @Provides
    @Singleton
    fun provideShopsApi(retrofit: Retrofit): ShopsApi =
        retrofit.create()


    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptorImpl: AuthInterceptorImpl): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptorImpl)
            .build()

    @Singleton
    @Provides
    fun provideAuthInterceptorImpl(
        sessionManager: SessionManager
    ): AuthInterceptorImpl = AuthInterceptorImpl(sessionManager)

    /* SESSION MANAGER DEPENDENCY CHAIN */
    @Singleton
    @Provides
    fun provideSessionManager(
        appSharedPreferences: AppSharedPreferences,
    ): SessionManager = SessionManager(appSharedPreferences)

    @Singleton
    @Provides
    fun provideAppSharedPreferences(
        sharedPreferences: SharedPreferences
    ): AppSharedPreferences = AppSharedPreferences(sharedPreferences)

    @Singleton
    @Provides
    fun provideSharedPreferences(
        @ApplicationContext context: Context,
    ): SharedPreferences =
        context.getSharedPreferences(AppSharedPreferences.SHARED_PREFS, Context.MODE_PRIVATE)

    /* DATABASE */

    @Provides
    @Singleton
    fun provideRoomConverters(moshi: Moshi): RoomConverters =
        RoomConverters(moshi)

    @Provides
    @Singleton
    fun provideMalacProdavacDatabase(
        app: Application,
        converters: RoomConverters
    ): MalacProdavacDatabase =
        Room.databaseBuilder(
            app,
            MalacProdavacDatabase::class.java,
            "malacprodavac.db"
        ).addTypeConverter(converters)
            .fallbackToDestructiveMigration()
            .build()


}