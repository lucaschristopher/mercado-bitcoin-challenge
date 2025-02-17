package com.example.mercadobitcoinchallenge.domain.di

import com.example.mercadobitcoinchallenge.domain.repository.MBitcoinRepository
import com.example.mercadobitcoinchallenge.domain.usecase.GetExchangeListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
internal object UseCaseModule {

    @Provides
    fun providesGetExchangeListUseCase(
        repository: MBitcoinRepository
    ): GetExchangeListUseCase = GetExchangeListUseCase(repository::getExchangeList)
}
