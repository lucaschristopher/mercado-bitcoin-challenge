package com.example.mercadobitcoinchallenge.data.di.module

import com.example.mercadobitcoinchallenge.data.datasource.MBitcoinRemoteDataSource
import com.example.mercadobitcoinchallenge.data.di.qualifier.IODispatcher
import com.example.mercadobitcoinchallenge.data.repository.MBitcoinRepositoryImpl
import com.example.mercadobitcoinchallenge.domain.repository.MBitcoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Provides
    @Singleton

    fun providesMBitcoinRepository(
        remoteDataSource: MBitcoinRemoteDataSource,
        @IODispatcher dispatcher: CoroutineDispatcher
    ): MBitcoinRepository = MBitcoinRepositoryImpl(remoteDataSource, dispatcher)
}
