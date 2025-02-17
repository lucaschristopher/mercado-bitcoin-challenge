package com.example.mercadobitcoinchallenge.data.datasource

import com.example.mercadobitcoinchallenge.data.model.ExchangeResponse
import com.example.mercadobitcoinchallenge.data.service.MBitcoinService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class MBitcoinRemoteDataSourceImpl @Inject constructor(
    private val service: MBitcoinService
) : MBitcoinRemoteDataSource {

    override suspend fun getExchangeList(): Flow<List<ExchangeResponse>> = flow {
        val response = service.getExchangeList(page = 1, pageSize = 10) // TODO: Implement pagination
        emit(response)
    }
}
