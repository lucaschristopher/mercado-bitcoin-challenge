package com.example.mercadobitcoinchallenge.commons.extensions

import com.example.mercadobitcoinchallenge.commons.flow.FlowResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

fun <T, O> Flow<FlowResult<T, O>>.onSuccess(
    action: suspend (T) -> Unit
): Flow<FlowResult<T, O>> = onEach {
    if (it is FlowResult.Success) action.invoke(it.data)
}

fun <T, O> Flow<FlowResult<T, O>>.onError(
    action: suspend (O) -> Unit
): Flow<FlowResult<T, O>> = onEach {
    if (it is FlowResult.Error) action.invoke(it.error)
}
