package com.example.mercadobitcoinchallenge.domain.usecase

import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import kotlinx.coroutines.flow.Flow

internal fun interface GetExchangeListUseCase : suspend () -> Flow<List<ExchangeModel>>
