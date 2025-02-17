package com.example.mercadobitcoinchallenge.domain.repository

import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import kotlinx.coroutines.flow.Flow

internal interface MBitcoinRepository {
    suspend fun getExchangeList(): Flow<List<ExchangeModel>>
}
