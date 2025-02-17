package com.example.mercadobitcoinchallenge.domain.usecase

import com.example.mercadobitcoinchallenge.commons.flow.FlowResult
import com.example.mercadobitcoinchallenge.commons.usecase.UseCase
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import com.example.mercadobitcoinchallenge.domain.repository.MBitcoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class GetExchangeListUseCase @Inject constructor(
    private val repository: MBitcoinRepository
) : UseCase<List<ExchangeModel>, Throwable> {

    override fun invoke(): Flow<FlowResult<List<ExchangeModel>, Throwable>> = flow {
        repository.getExchangeList().catch {
            emit(FlowResult.Error(it))
        }.collect {
            emit(FlowResult.Success(it))
        }
    }
}
