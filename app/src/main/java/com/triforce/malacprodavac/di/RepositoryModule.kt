package com.triforce.malacprodavac.di

import com.triforce.malacprodavac.data.repository.auth.AuthRepositoryImpl
import com.triforce.malacprodavac.data.repository.categories.CategoryRepositoryImpl
import com.triforce.malacprodavac.data.repository.couriers.CourierRepositoryImpl
import com.triforce.malacprodavac.data.repository.customers.CustomerRepositoryImpl
import com.triforce.malacprodavac.data.repository.shops.ShopRepositoryImpl
import com.triforce.malacprodavac.data.repository.users.UserRepositoryImpl
import com.triforce.malacprodavac.domain.repository.AuthRepository
import com.triforce.malacprodavac.domain.repository.CategoryRepository
import com.triforce.malacprodavac.domain.repository.CourierRepository
import com.triforce.malacprodavac.domain.repository.CustomerRepository
import com.triforce.malacprodavac.domain.repository.ShopRepository
import com.triforce.malacprodavac.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindsUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindsCustomerRepository(
        customerRepositoryImpl: CustomerRepositoryImpl
    ): CustomerRepository

    @Binds
    @Singleton
    abstract fun bindsCourierRepository(
        courierRepositoryImpl: CourierRepositoryImpl
    ): CourierRepository

    @Binds
    @Singleton
    abstract fun bindsShopRepository(
        shopRepositoryImpl: ShopRepositoryImpl
    ): ShopRepository

    @Binds
    @Singleton
    abstract fun bindsCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository

}