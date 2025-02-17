package com.example.mercadobitcoinchallenge.data.di.module

import com.example.mercadobitcoinchallenge.data.datasource.MBitcoinRemoteDataSource
import com.example.mercadobitcoinchallenge.data.datasource.MBitcoinRemoteDataSourceImpl
import com.example.mercadobitcoinchallenge.data.service.MBitcoinService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {

    @Provides
    @Singleton
    fun providesMBitcoinRemoteDataSource(
        service: MBitcoinService
    ): MBitcoinRemoteDataSource = MBitcoinRemoteDataSourceImpl(service)
}
