package com.example.mercadobitcoinchallenge.data.di.module

import com.example.mercadobitcoinchallenge.core.network.provider.factory.ApiFactory
import com.example.mercadobitcoinchallenge.data.di.qualifier.RetrofitDefault
import com.example.mercadobitcoinchallenge.data.service.MBitcoinService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ServiceModule {

    @Provides
    @Singleton
    fun providesMBitcoinService(
        @RetrofitDefault retrofit: Retrofit
    ): MBitcoinService =
        ApiFactory.build(
            retrofit = retrofit,
            apiClass = MBitcoinService::class.java
        )
}
