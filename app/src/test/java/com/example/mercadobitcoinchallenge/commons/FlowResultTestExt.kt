package com.example.mercadobitcoinchallenge.commons

import com.example.mercadobitcoinchallenge.commons.flow.FlowResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

suspend fun <SUCCESS, ERROR> Flow<FlowResult<SUCCESS, ERROR>>.getError(): ERROR? {
    return firstOrNull { it is FlowResult.Error }
        ?.let { (it as? FlowResult.Error)?.error }
}

suspend fun <SUCCESS, ERROR> Flow<FlowResult<SUCCESS, ERROR>>.getSuccess(): SUCCESS? {
    return firstOrNull { it is FlowResult.Success }
        ?.let { (it as? FlowResult.Success)?.data }
}

