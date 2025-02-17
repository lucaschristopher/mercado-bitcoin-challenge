package com.example.mercadobitcoinchallenge.data.datasource

import com.example.mercadobitcoinchallenge.data.model.ExchangeResponse
import kotlinx.coroutines.flow.Flow

internal interface MBitcoinRemoteDataSource {
    suspend fun getExchangeList(): Flow<List<ExchangeResponse>>
}
