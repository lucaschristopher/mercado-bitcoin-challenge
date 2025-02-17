package com.example.mercadobitcoinchallenge.data.repository

import com.example.mercadobitcoinchallenge.data.datasource.MBitcoinRemoteDataSource
import com.example.mercadobitcoinchallenge.data.mapper.toDomain
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import com.example.mercadobitcoinchallenge.domain.repository.MBitcoinRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class MBitcoinRepositoryImpl @Inject constructor(
    private val remoteDataSource: MBitcoinRemoteDataSource,
    private val dispatcher: CoroutineDispatcher
) : MBitcoinRepository {

    override suspend fun getExchangeList(): Flow<List<ExchangeModel>> = flow {
        remoteDataSource.getExchangeList().collect { response ->
            emit(response.map { it.toDomain() })
        }
    }.flowOn(dispatcher)
}
